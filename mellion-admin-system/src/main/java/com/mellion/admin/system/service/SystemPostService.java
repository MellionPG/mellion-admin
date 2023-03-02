package com.mellion.admin.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.system.entity.TSystemPost;

/**
 * 系统岗位服务接口
 *
 * @author MellionPG
 * @date 2023/3/2 16:00
 **/
public interface SystemPostService {

    /**
     * 根据id获取系统岗位详情
     *
     * @param id 主键
     * @return 系统岗位详情
     */
    TSystemPost getById(Long id);

    /**
     * 新增系统岗位
     *
     * @param tSystemPost 系统岗位
     * @return 系统岗位
     */
    TSystemPost add(TSystemPost tSystemPost);

    /**
     * 修改系统岗位
     *
     * @param tSystemPost 系统岗位
     * @return 系统岗位
     */
    TSystemPost editById(TSystemPost tSystemPost);

    /**
     * 根据id删除系统岗位
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取系统岗位
     *
     * @param pageParam 分页参数
     * @return 分页后的系统岗位
     */
    Page<TSystemPost> getPage(PageParam pageParam);

}
