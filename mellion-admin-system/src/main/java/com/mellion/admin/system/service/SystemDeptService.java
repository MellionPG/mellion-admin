package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemDept;

/**
 * 系统部门服务接口
 *
 * @author MellionPG
 * @date 2023/3/2 15:54
 **/
public interface SystemDeptService {

    /**
     * 根据id获取系统部门详情
     *
     * @param id 主键
     * @return 系统部门详情
     */
    TSystemDept getById(Long id);

    /**
     * 新增系统部门
     *
     * @param tSystemDept 系统部门
     * @return 系统部门
     */
    TSystemDept add(TSystemDept tSystemDept);

    /**
     * 修改系统部门
     *
     * @param tSystemDept 系统部门
     * @return 系统部门
     */
    TSystemDept editById(TSystemDept tSystemDept);

    /**
     * 根据id删除系统部门
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统部门
     *
     * @param pageParam 分页参数
     * @return 分页后的系统部门
     */
    Page<TSystemDept> getPage(PageParam pageParam);

}
