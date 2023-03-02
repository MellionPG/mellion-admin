package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.annotation.EnableDictInjection;
import com.mellion.admin.system.entity.TSystemDept;
import com.mellion.admin.system.service.SystemDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统部门控制器
 *
 * @author MellionPG
 * @date 2023/3/2 16:22
 **/
@RestController
@RequestMapping("/system/dept")
@Validated
@Api(tags = "系统模块 - 部门接口")
@RequiredArgsConstructor
@EnableDictInjection
public class SystemDeptController {

    /**
     * 系统部门服务
     */
    private final SystemDeptService systemDeptService;

    /**
     * 根据id获取系统部门详情
     *
     * @param id 主键
     * @return 系统部门详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统部门详情")
    public ResponseResult<TSystemDept> getById(@RequestParam Long id) {
        return ResponseResult.success(systemDeptService.getById(id));
    }

    /**
     * 新增系统部门
     *
     * @param tSystemDept 系统部门
     * @return 系统部门
     */
    @PostMapping
    @ApiOperation("新增系统部门")
    public ResponseResult<TSystemDept> add(@RequestBody @Valid TSystemDept tSystemDept) {
        return ResponseResult.success(systemDeptService.add(tSystemDept));
    }

    /**
     * 根据id修改系统部门
     *
     * @param tSystemDept 系统部门
     * @return 系统部门
     */
    @PutMapping
    @ApiOperation("根据id修改系统部门")
    public ResponseResult<TSystemDept> editById(@RequestBody @Valid TSystemDept tSystemDept) {
        return ResponseResult.success(systemDeptService.editById(tSystemDept));
    }

    /**
     * 根据id删除系统部门
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemDeptService.deleteById(id));
    }

    /**
     * 分页获取系统部门
     *
     * @param pageParam 分页参数
     * @return 分页后的系统部门
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统部门")
    public ResponseResult<Page<TSystemDept>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemDeptService.getPage(pageParam));
    }

}
