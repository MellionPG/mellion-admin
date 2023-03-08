package com.mellion.admin.system.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.utils.RedisUtil;
import com.mellion.admin.system.annotation.DictDefineProperty;
import com.mellion.admin.system.constant.RedisKeyPrefixConstant;
import com.mellion.admin.system.dto.UserPermissionInfoDTO;
import com.mellion.admin.system.entity.TSystemMenu;
import com.mellion.admin.system.entity.TSystemUser;
import com.mellion.admin.system.enums.SystemResponseStatus;
import com.mellion.admin.system.manager.SystemUserManager;
import com.mellion.admin.system.mapper.TSystemUserMapper;
import com.mellion.admin.system.param.LoginFormRequestParam;
import com.mellion.admin.system.service.SystemDictDefineService;
import com.mellion.admin.system.service.SystemDictItemService;
import com.mellion.admin.system.service.SystemUserService;
import com.mellion.admin.system.vo.UserLoginTokenVO;
import com.mellion.admin.system.vo.UserPermissionInfoVO;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 系统用户服务实现
 *
 * @author MellionPG
 * @date 2023/3/2 16:13
 **/
@Service
@RequiredArgsConstructor
public class SystemUserServiceImpl implements SystemUserService {

    /**
     * 系统用户Mapper
     */
    private final TSystemUserMapper tSystemUserMapper;

    /**
     * 系统用户Manager
     */
    private final SystemUserManager systemUserManager;

    /**
     * 系统字典定义Service
     */
    private final SystemDictDefineService systemDictDefineService;

    /**
     * 系统字典项Service
     */
    private final SystemDictItemService systemDictItemService;

    @Override
    public TSystemUser getById(Long id) {
        return tSystemUserMapper.selectById(id);
    }

    @Override
    public TSystemUser add(TSystemUser tSystemUser) {
        tSystemUser.setId(null);
        tSystemUserMapper.insert(tSystemUser);
        return getById(tSystemUser.getId());
    }

    @Override
    public TSystemUser editById(TSystemUser tSystemUser) {
        Long id = tSystemUser.getId();
        if (Objects.isNull(id)) {
            throw new ServiceException(BaseResponseStatus.ID_IS_NULL);
        }
        if (Objects.isNull(tSystemUserMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemUserMapper.updateById(tSystemUser);
        return tSystemUserMapper.selectById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if (Objects.isNull(tSystemUserMapper.selectById(id))) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }
        tSystemUserMapper.deleteById(id);
        return true;
    }

    @Override
    public Page<TSystemUser> getPage(PageParam pageParam) {
        Page<TSystemUser> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        return tSystemUserMapper.selectPage(page, null);
    }

    @Override
    public UserLoginTokenVO login(LoginFormRequestParam loginForm) {
        // 根据username在数据库查询用户
        String usernameSrc = loginForm.getUsername();
        TSystemUser userInDb = tSystemUserMapper.selectByUsername(usernameSrc);
        // 判断用户是否为空
        if (Objects.isNull(userInDb)) {
            // 如果为空，说明用户不存在，抛出异常
            throw new ServiceException(SystemResponseStatus.LOGIN_BAD_CREDENTIALS);
        }
        // 判断数据库中的用户信息密码是否为空
        String passwordInDb = userInDb.getPassword();
        if (Strings.isEmpty(passwordInDb)) {
            // 如果为空，说明用户未设置密码，抛出异常
            throw new ServiceException(SystemResponseStatus.PASSWORD_NOT_SET);
        }
        // 判断密码是否正确
        if (!passwordInDb.equals(loginForm.getPassword())) {
            // 如果不正确，抛出异常
            throw new ServiceException(SystemResponseStatus.LOGIN_BAD_CREDENTIALS);
        }
        // 判断账号是否被禁用
        if (userInDb.getStatus() == 0) {
            // 如果被禁用，抛出异常
            throw new ServiceException(SystemResponseStatus.LOGIN_USER_DISABLED);
        }

        // 执行到这说明校验通过
        // 根据用户id和uuid拼接成token
        String token = userInDb.getId().toString() + UUID.randomUUID();
        // 把token存到redis
        if (loginForm.getSaveLoginStatus()) {
            RedisUtil.set(RedisKeyPrefixConstant.SYSTEM_USER_TOKEN + userInDb.getId(), token, 15 * 24 * 60 * 60);
        } else {
            RedisUtil.set(RedisKeyPrefixConstant.SYSTEM_USER_TOKEN + userInDb.getId(), token, 24 * 60 * 60);
        }
        // 完成把前端要的权限信息封装成vo，返回给前端
        return new UserLoginTokenVO(token);
    }

    @Override
    public UserPermissionInfoVO getPermissionInfo(String token) throws NoSuchFieldException {
        Long userId = Long.parseLong(token.substring(0, 19));
        // 1. 完成后端的获取权限信息和存储到redis
        List<TSystemMenu> systemMenus = grantPermissionsInBackend(userId);

        // 2. 根据用户id查询用户
        TSystemUser userInDb = tSystemUserMapper.selectById(userId);
        if (Objects.isNull(userInDb)) {
            throw new ServiceException(BaseResponseStatus.DATA_IS_NULL);
        }

        // 3. 把权限信息封装并返回给前端
        return grantPermissionsToFrontend(userInDb, systemMenus);
    }

    private List<TSystemMenu> grantPermissionsInBackend(Long userId) throws NoSuchFieldException {
        // 目标对象
        UserPermissionInfoDTO userPermissionInfo = new UserPermissionInfoDTO();

        // 1. 根据用户id查询菜单列表
        List<TSystemMenu> systemMenus = systemUserManager.getSystemMenusByUserId(userId);

        // 2. 判断菜单列表是否为空
        if (systemMenus != null && !systemMenus.isEmpty()) {
            // 如果菜单列表不为空，封装菜单信息
            // 2.1 首先获取requestMethod枚举字段的字典信息
            String dictCode = TSystemMenu.class.getDeclaredField("requestMethod").getAnnotation(DictDefineProperty.class).dictCode();
            Long defineId = systemDictDefineService.getDefineIdByCode(dictCode);
            Map<String, String> dictItemInfoMap = systemDictItemService.getItemValueAndTextByDefineId(defineId);

            // 2.2 判断字典信息是否为空
            if (dictItemInfoMap != null && !dictItemInfoMap.isEmpty()) {
                // 2.3 开始遍历菜单列表
                List<String> menuMainInfoList = new ArrayList<>();
                systemMenus.forEach(systemMenu -> {
                    String requestUrl = systemMenu.getRequestUrl();
                    Integer requestMethodDict = systemMenu.getRequestMethod();
                    if (requestUrl != null && requestMethodDict != null) {
                        String requestMethod = dictItemInfoMap.get(requestMethodDict.toString());

                        String menuMainInfo = null;
                        if (Objects.isNull(requestMethod)) {
                            menuMainInfo = requestUrl + "@" + requestMethodDict;
                        } else {
                            menuMainInfo = requestUrl + "@" + requestMethod;
                        }
                        menuMainInfoList.add(menuMainInfo);
                    }
                });
                userPermissionInfo.setMenuMainInfoList(menuMainInfoList);
            }
        }

        // 3. 把权限信息对象存储到redis
        RedisUtil.set(RedisKeyPrefixConstant.SYSTEM_USER_PERMISSION + userId, userPermissionInfo, 15 * 24 * 60 * 60);

        return systemMenus;
    }

    private UserPermissionInfoVO grantPermissionsToFrontend(TSystemUser userInDb, List<TSystemMenu> systemMenus) {
        UserPermissionInfoVO userPermissionInfo = new UserPermissionInfoVO();

        // 1. 封装用户信息
        userPermissionInfo.setUsername(userInDb.getUsername());
        userPermissionInfo.setNickname(userInDb.getNickname());
        userPermissionInfo.setAvatar(userInDb.getAvatar());

        // 2. 封装组件路径
        if (systemMenus != null && !systemMenus.isEmpty()) {
            List<String> componentUrlList = new ArrayList<>();
            systemMenus.forEach(systemMenu -> {
                componentUrlList.add(systemMenu.getComponentUrl());
            });
            userPermissionInfo.setComponentUrlList(componentUrlList);
        }

        return userPermissionInfo;
    }

    @Override
    public void logout(String token) {
        // 先根据token拿到用户id
        String userId = token.substring(0, 19);

        // 移除redis中的token和permission信息
        RedisUtil.remove(RedisKeyPrefixConstant.SYSTEM_USER_TOKEN + userId);
        RedisUtil.remove(RedisKeyPrefixConstant.SYSTEM_USER_PERMISSION + userId);
    }
}
