package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemRole;

/**
 * 系统角色服务接口
 *
 * @author MellionPG
 * @date 2023/3/2 16:01
 **/
public interface SystemRoleService {

    /**
     * 根据id获取系统角色详情
     *
     * @param id 主键
     * @return 系统角色详情
     */
    TSystemRole getById(Long id);

    /**
     * 新增系统角色
     *
     * @param tSystemRole 系统角色
     * @return 系统角色
     */
    TSystemRole add(TSystemRole tSystemRole);

    /**
     * 修改系统角色
     *
     * @param tSystemRole 系统角色
     * @return 系统角色
     */
    TSystemRole editById(TSystemRole tSystemRole);

    /**
     * 根据id删除系统角色
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统角色
     *
     * @param pageParam 分页参数
     * @return 分页后的系统角色
     */
    Page<TSystemRole> getPage(PageParam pageParam);

}
