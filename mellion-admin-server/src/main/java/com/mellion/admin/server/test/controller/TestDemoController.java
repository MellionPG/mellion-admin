package com.mellion.admin.server.test.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.server.test.entity.TTestDemo;
import com.mellion.admin.server.test.service.TestDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 测试样例控制器
 *
 * @author MellionPG
 * @date 2023/2/27 10:48
 **/
@RestController
@RequestMapping("/test/demo")
@Validated
@Api(tags = "测试模块 - 样例接口")
@RequiredArgsConstructor
public class TestDemoController {

    /**
     * 测试样例服务
     */
    private final TestDemoService testDemoService;

    /**
     * 根据id获取测试样例详情
     *
     * @param id 主键
     * @return 测试样例详情
     */
    @GetMapping
    @ApiOperation("根据id获取测试样例详情")
    public ResponseResult<TTestDemo> getById(@RequestParam Long id) {
        return ResponseResult.success(testDemoService.getById(id));
    }

    /**
     * 新增测试样例
     *
     * @param tTestDemo 测试样例
     * @return 测试样例
     */
    @PostMapping
    @ApiOperation("新增测试样例")
    public ResponseResult<TTestDemo> add(@RequestBody @Valid TTestDemo tTestDemo) {
        return ResponseResult.success(testDemoService.add(tTestDemo));
    }

    /**
     * 根据id修改测试样例
     *
     * @param tTestDemo 测试样例
     * @return 测试样例
     */
    @PutMapping
    @ApiOperation("根据id修改测试样例")
    public ResponseResult<TTestDemo> editById(@RequestBody @Valid TTestDemo tTestDemo) {
        return ResponseResult.success(testDemoService.editById(tTestDemo));
    }

    /**
     * 根据id删除测试样例
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(testDemoService.deleteById(id));
    }

    /**
     * 分页获取测试样例
     *
     * @param pageParam 分页参数
     * @return 分页后的测试样例
     */
    @GetMapping("/page")
    @ApiOperation("分页获取测试样例")
    public ResponseResult<Page<TTestDemo>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(testDemoService.getPage(pageParam));
    }

}
