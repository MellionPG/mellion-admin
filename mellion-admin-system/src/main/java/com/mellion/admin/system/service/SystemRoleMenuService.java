package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemRoleMenu;

import java.util.List;

/**
 * 系统角色和菜单关联服务接口
 *
 * @author MellionPG
 * @date 2023/3/2 16:02
 **/
public interface SystemRoleMenuService {

    /**
     * 根据id获取系统角色和菜单关联详情
     *
     * @param id 主键
     * @return 系统角色和菜单关联详情
     */
    TSystemRoleMenu getById(Long id);

    /**
     * 新增系统角色和菜单关联
     *
     * @param tSystemRoleMenu 系统角色和菜单关联
     * @return 系统角色和菜单关联
     */
    TSystemRoleMenu add(TSystemRoleMenu tSystemRoleMenu);

    /**
     * 修改系统角色和菜单关联
     *
     * @param tSystemRoleMenu 系统角色和菜单关联
     * @return 系统角色和菜单关联
     */
    TSystemRoleMenu editById(TSystemRoleMenu tSystemRoleMenu);

    /**
     * 根据id删除系统角色和菜单关联
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统角色和菜单关联
     *
     * @param pageParam 分页参数
     * @return 分页后的系统角色和菜单关联
     */
    Page<TSystemRoleMenu> getPage(PageParam pageParam);

    /**
     * 根据角色id查询菜单ids
     *
     * @param roleId 角色id
     * @return 菜单id列表
     */
    List<Long> getMenuIdsByRoleId(Long roleId);

}
