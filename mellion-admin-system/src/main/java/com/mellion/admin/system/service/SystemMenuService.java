package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemMenu;

/**
 * 系统菜单服务接口
 *
 * @author MellionPG
 * @date 2023/3/2 15:58
 **/
public interface SystemMenuService {

    /**
     * 根据id获取系统菜单详情
     *
     * @param id 主键
     * @return 系统菜单详情
     */
    TSystemMenu getById(Long id);

    /**
     * 新增系统菜单
     *
     * @param tSystemMenu 系统菜单
     * @return 系统菜单
     */
    TSystemMenu add(TSystemMenu tSystemMenu);

    /**
     * 修改系统菜单
     *
     * @param tSystemMenu 系统菜单
     * @return 系统菜单
     */
    TSystemMenu editById(TSystemMenu tSystemMenu);

    /**
     * 根据id删除系统菜单
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统菜单
     *
     * @param pageParam 分页参数
     * @return 分页后的系统菜单
     */
    Page<TSystemMenu> getPage(PageParam pageParam);

}
