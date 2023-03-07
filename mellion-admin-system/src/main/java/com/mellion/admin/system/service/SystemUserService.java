package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemUser;
import com.mellion.admin.system.param.LoginFormRequestParam;
import com.mellion.admin.system.vo.UserLoginTokenVO;
import com.mellion.admin.system.vo.UserPermissionInfoVO;

/**
 * 系统用户服务接口
 *
 * @author MellionPG
 * @date 2023/3/2 16:03
 **/
public interface SystemUserService {

    /**
     * 根据id获取系统用户详情
     *
     * @param id 主键
     * @return 系统用户详情
     */
    TSystemUser getById(Long id);

    /**
     * 新增系统用户
     *
     * @param tSystemUser 系统用户
     * @return 系统用户
     */
    TSystemUser add(TSystemUser tSystemUser);

    /**
     * 修改系统用户
     *
     * @param tSystemUser 系统用户
     * @return 系统用户
     */
    TSystemUser editById(TSystemUser tSystemUser);

    /**
     * 根据id删除系统用户
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统用户
     *
     * @param pageParam 分页参数
     * @return 分页后的系统用户
     */
    Page<TSystemUser> getPage(PageParam pageParam);

    /**
     * 账号密码登录
     *
     * @param loginForm 登录表单
     * @return 登录结果
     */
    UserLoginTokenVO login(LoginFormRequestParam loginForm);

    /**
     * 获取用户权限信息
     *
     * @param token 登录令牌
     * @return 权限信息
     */
    UserPermissionInfoVO getPermissionInfo(String token) throws NoSuchFieldException;

}
