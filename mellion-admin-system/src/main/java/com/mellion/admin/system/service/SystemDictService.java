package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemDictDefine;

/**
 * 系统字典定义服务接口
 *
 * @author MellionPG
 * @date 2023/2/28 11:28
 **/
public interface SystemDictService {

    /**
     * 根据id获取系统字典定义详情
     *
     * @param id 主键
     * @return 系统字典定义详情
     */
    TSystemDictDefine getById(Long id);

    /**
     * 新增测试样例
     *
     * @param tSystemDictDefine 系统字典定义
     * @return 系统字典定义
     */
    TSystemDictDefine add(TSystemDictDefine tSystemDictDefine);

    /**
     * 修改测试样例
     *
     * @param tSystemDictDefine 系统字典定义
     * @return 系统字典定义
     */
    TSystemDictDefine editById(TSystemDictDefine tSystemDictDefine);

    /**
     * 根据id删除系统字典定义
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统字典定义
     *
     * @param pageParam 分页参数
     * @return 分页后的系统字典定义
     */
    Page<TSystemDictDefine> getPage(PageParam pageParam);

}
