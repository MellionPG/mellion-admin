package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.annotation.EnableDictInjection;
import com.mellion.admin.system.entity.TSystemRole;
import com.mellion.admin.system.service.SystemRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统角色控制器
 *
 * @author MellionPG
 * @date 2023/3/2 16:30
 **/
@RestController
@RequestMapping("/system/role")
@Validated
@Api(tags = "系统模块 - 角色接口")
@RequiredArgsConstructor
@EnableDictInjection
public class SystemRoleController {

    /**
     * 系统角色服务
     */
    private final SystemRoleService systemRoleService;

    /**
     * 根据id获取系统角色详情
     *
     * @param id 主键
     * @return 系统角色详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统角色详情")
    public ResponseResult<TSystemRole> getById(@RequestParam Long id) {
        return ResponseResult.success(systemRoleService.getById(id));
    }

    /**
     * 新增系统角色
     *
     * @param tSystemRole 系统角色
     * @return 系统角色
     */
    @PostMapping
    @ApiOperation("新增系统角色")
    public ResponseResult<TSystemRole> add(@RequestBody @Valid TSystemRole tSystemRole) {
        return ResponseResult.success(systemRoleService.add(tSystemRole));
    }

    /**
     * 根据id修改系统角色
     *
     * @param tSystemRole 系统角色
     * @return 系统角色
     */
    @PutMapping
    @ApiOperation("根据id修改系统角色")
    public ResponseResult<TSystemRole> editById(@RequestBody @Valid TSystemRole tSystemRole) {
        return ResponseResult.success(systemRoleService.editById(tSystemRole));
    }

    /**
     * 根据id删除系统角色
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemRoleService.deleteById(id));
    }

    /**
     * 分页获取系统角色
     *
     * @param pageParam 分页参数
     * @return 分页后的系统角色
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统角色")
    public ResponseResult<Page<TSystemRole>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemRoleService.getPage(pageParam));
    }

}
