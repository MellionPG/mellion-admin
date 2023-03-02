package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.annotation.EnableDictInjection;
import com.mellion.admin.system.entity.TSystemPost;
import com.mellion.admin.system.service.SystemPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统岗位控制器
 *
 * @author MellionPG
 * @date 2023/3/2 16:30
 **/
@RestController
@RequestMapping("/system/post")
@Validated
@Api(tags = "系统模块 - 岗位接口")
@RequiredArgsConstructor
@EnableDictInjection
public class SystemPostController {

    /**
     * 系统岗位服务
     */
    private final SystemPostService systemPostService;

    /**
     * 根据id获取系统岗位详情
     *
     * @param id 主键
     * @return 系统岗位详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统岗位详情")
    public ResponseResult<TSystemPost> getById(@RequestParam Long id) {
        return ResponseResult.success(systemPostService.getById(id));
    }

    /**
     * 新增系统岗位
     *
     * @param tSystemPost 系统岗位
     * @return 系统岗位
     */
    @PostMapping
    @ApiOperation("新增系统岗位")
    public ResponseResult<TSystemPost> add(@RequestBody @Valid TSystemPost tSystemPost) {
        return ResponseResult.success(systemPostService.add(tSystemPost));
    }

    /**
     * 根据id修改系统岗位
     *
     * @param tSystemPost 系统岗位
     * @return 系统岗位
     */
    @PutMapping
    @ApiOperation("根据id修改系统岗位")
    public ResponseResult<TSystemPost> editById(@RequestBody @Valid TSystemPost tSystemPost) {
        return ResponseResult.success(systemPostService.editById(tSystemPost));
    }

    /**
     * 根据id删除系统岗位
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemPostService.deleteById(id));
    }

    /**
     * 分页获取系统岗位
     *
     * @param pageParam 分页参数
     * @return 分页后的系统岗位
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统岗位")
    public ResponseResult<Page<TSystemPost>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemPostService.getPage(pageParam));
    }

}
