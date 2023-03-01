package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemDictItem;

import java.util.Map;

/**
 * 系统字典项服务接口
 *
 * @author MellionPG
 * @date 2023/2/28 12:01
 **/
public interface SystemDictItemService {

    /**
     * 根据id获取系统字典项详情
     *
     * @param id 主键
     * @return 系统字典项详情
     */
    TSystemDictItem getById(Long id);

    /**
     * 新增系统字典项
     *
     * @param tSystemDictItem 系统字典项
     * @return 系统字典项
     */
    TSystemDictItem add(TSystemDictItem tSystemDictItem);

    /**
     * 修改系统字典项
     *
     * @param tSystemDictItem 系统字典项
     * @return 系统字典项
     */
    TSystemDictItem editById(TSystemDictItem tSystemDictItem);

    /**
     * 根据id删除系统字典项
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统字典项
     *
     * @param pageParam 分页参数
     * @return 分页后的系统字典项
     */
    Page<TSystemDictItem> getPage(PageParam pageParam);

    /**
     * 根据字典定义ID查所有字典项的value和text
     *
     * @param defineId 字典定义ID
     * @return 由字典项value和text组成的map
     */
    Map<String, String> getItemValueAndTextByDefineId(Long defineId);

}
