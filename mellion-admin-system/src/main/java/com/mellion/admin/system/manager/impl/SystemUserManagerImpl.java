package com.mellion.admin.system.manager.impl;

import com.mellion.admin.system.entity.TSystemMenu;
import com.mellion.admin.system.manager.SystemUserManager;
import com.mellion.admin.system.service.SystemMenuService;
import com.mellion.admin.system.service.SystemRoleMenuService;
import com.mellion.admin.system.service.SystemUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 系统用户Manager接口实现
 *
 * @author MellionPG
 * @date 2023/3/6 20:51
 **/
@Service
@RequiredArgsConstructor
public class SystemUserManagerImpl implements SystemUserManager {

    /**
     * 系统用户和角色关联Service
     */
    private final SystemUserRoleService systemUserRoleService;

    /**
     * 系统角色和菜单关联Service
     */
    private final SystemRoleMenuService systemRoleMenuService;

    /**
     * 系统菜单Service
     */
    private final SystemMenuService systemMenuService;


    @Override
    public List<TSystemMenu> getSystemMenusByUserId(Long userId) {
        // 根据用户id查询角色ids
        List<Long> roleIds = systemUserRoleService.getRoleIdsByUserId(userId);
        // 判断角色ids是否为空
        if (Objects.isNull(roleIds) || roleIds.isEmpty()) {
            // 如果roleIds为空，直接返回
            return null;
        }
        List<Long> menuIds = new ArrayList<>(roleIds.size());
        roleIds.forEach(roleId -> {
            // 根据角色id查询菜单ids
            List<Long> subMenuIds = systemRoleMenuService.getMenuIdsByRoleId(roleId);
            menuIds.addAll(subMenuIds);
        });
        // 判断菜单ids是否为空
        if (menuIds.isEmpty()) {
            // 如果menuIds为空，直接返回
            return null;
        }
        List<TSystemMenu> systemMenus = new ArrayList<>();
        menuIds.forEach(menuId -> {
            // 根据菜单id查询菜单详情
            TSystemMenu systemMenu = systemMenuService.getById(menuId);
            systemMenus.add(systemMenu);
        });
        return systemMenus;
    }
    
}
