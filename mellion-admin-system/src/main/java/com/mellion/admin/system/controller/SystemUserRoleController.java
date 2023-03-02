package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.annotation.EnableDictInjection;
import com.mellion.admin.system.entity.TSystemUserRole;
import com.mellion.admin.system.service.SystemUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统用户和角色关联控制器
 *
 * @author MellionPG
 * @date 2023/3/2 16:31
 **/
@RestController
@RequestMapping("/system/user/role")
@Validated
@Api(tags = "系统模块 - 用户和角色关联接口")
@RequiredArgsConstructor
@EnableDictInjection
public class SystemUserRoleController {

    /**
     * 系统用户和角色关联服务
     */
    private final SystemUserRoleService systemUserRoleService;

    /**
     * 根据id获取系统用户和角色关联详情
     *
     * @param id 主键
     * @return 系统用户和角色关联详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统用户和角色关联详情")
    public ResponseResult<TSystemUserRole> getById(@RequestParam Long id) {
        return ResponseResult.success(systemUserRoleService.getById(id));
    }

    /**
     * 新增系统用户和角色关联
     *
     * @param tSystemUserRole 系统用户和角色关联
     * @return 系统用户和角色关联
     */
    @PostMapping
    @ApiOperation("新增系统用户和角色关联")
    public ResponseResult<TSystemUserRole> add(@RequestBody @Valid TSystemUserRole tSystemUserRole) {
        return ResponseResult.success(systemUserRoleService.add(tSystemUserRole));
    }

    /**
     * 根据id修改系统用户和角色关联
     *
     * @param tSystemUserRole 系统用户和角色关联
     * @return 系统用户和角色关联
     */
    @PutMapping
    @ApiOperation("根据id修改系统用户和角色关联")
    public ResponseResult<TSystemUserRole> editById(@RequestBody @Valid TSystemUserRole tSystemUserRole) {
        return ResponseResult.success(systemUserRoleService.editById(tSystemUserRole));
    }

    /**
     * 根据id删除系统用户和角色关联
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemUserRoleService.deleteById(id));
    }

    /**
     * 分页获取系统用户和角色关联
     *
     * @param pageParam 分页参数
     * @return 分页后的系统用户和角色关联
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统用户和角色关联")
    public ResponseResult<Page<TSystemUserRole>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemUserRoleService.getPage(pageParam));
    }

}
