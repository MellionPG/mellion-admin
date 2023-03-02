package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemUserRole;

/**
 * 系统用户和角色关联服务接口
 *
 * @author MellionPG
 * @date 2023/3/2 16:04
 **/
public interface SystemUserRoleService {

    /**
     * 根据id获取系统用户和角色关联详情
     *
     * @param id 主键
     * @return 系统用户和角色关联详情
     */
    TSystemUserRole getById(Long id);

    /**
     * 新增系统用户和角色关联
     *
     * @param tSystemUserRole 系统用户和角色关联
     * @return 系统用户和角色关联
     */
    TSystemUserRole add(TSystemUserRole tSystemUserRole);

    /**
     * 修改系统用户和角色关联
     *
     * @param tSystemUserRole 系统用户和角色关联
     * @return 系统用户和角色关联
     */
    TSystemUserRole editById(TSystemUserRole tSystemUserRole);

    /**
     * 根据id删除系统用户和角色关联
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统用户和角色关联
     *
     * @param pageParam 分页参数
     * @return 分页后的系统用户和角色关联
     */
    Page<TSystemUserRole> getPage(PageParam pageParam);

}
