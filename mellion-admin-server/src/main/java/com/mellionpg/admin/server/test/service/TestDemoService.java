package com.mellionpg.admin.server.test.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellionpg.admin.base.pojo.PageParam;
import com.mellionpg.admin.server.test.entity.TTestDemo;

/**
 * 测试样例服务接口
 *
 * @author MellionPG
 * @date 2023/2/27 10:49
 **/
public interface TestDemoService {

    /**
     * 根据id获取测试样例详情
     *
     * @param id 主键
     * @return 测试样例详情
     */
    TTestDemo getById(Long id);

    /**
     * 新增测试样例
     *
     * @param tTestDemo 测试样例
     * @return 测试样例
     */
    TTestDemo add(TTestDemo tTestDemo);

    /**
     * 修改测试样例
     *
     * @param tTestDemo 测试样例
     * @return 测试样例
     */
    TTestDemo editById(TTestDemo tTestDemo);

    /**
     * 根据id删除测试样例
     *
     * @param id 主键
     * @return 删除状态
     */
    Boolean deleteById(Long id);

    /**
     * 分页获取测试样例
     *
     * @param pageParam 分页参数
     * @return 分页后的测试样例
     */
    Page<TTestDemo> getPage(PageParam pageParam);

}
