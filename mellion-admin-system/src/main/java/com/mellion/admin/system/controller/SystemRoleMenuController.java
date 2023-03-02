package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.annotation.EnableDictInjection;
import com.mellion.admin.system.entity.TSystemRoleMenu;
import com.mellion.admin.system.service.SystemRoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统角色和菜单关联控制器
 *
 * @author MellionPG
 * @date 2023/3/2 16:30
 **/
@RestController
@RequestMapping("/system/role/menu")
@Validated
@Api(tags = "系统模块 - 角色和菜单关联接口")
@RequiredArgsConstructor
@EnableDictInjection
public class SystemRoleMenuController {

    /**
     * 系统角色和菜单关联服务
     */
    private final SystemRoleMenuService systemRoleMenuService;

    /**
     * 根据id获取系统角色和菜单关联详情
     *
     * @param id 主键
     * @return 系统角色和菜单关联详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统角色和菜单关联详情")
    public ResponseResult<TSystemRoleMenu> getById(@RequestParam Long id) {
        return ResponseResult.success(systemRoleMenuService.getById(id));
    }

    /**
     * 新增系统角色和菜单关联
     *
     * @param tSystemRoleMenu 系统角色和菜单关联
     * @return 系统角色和菜单关联
     */
    @PostMapping
    @ApiOperation("新增系统角色和菜单关联")
    public ResponseResult<TSystemRoleMenu> add(@RequestBody @Valid TSystemRoleMenu tSystemRoleMenu) {
        return ResponseResult.success(systemRoleMenuService.add(tSystemRoleMenu));
    }

    /**
     * 根据id修改系统角色和菜单关联
     *
     * @param tSystemRoleMenu 系统角色和菜单关联
     * @return 系统角色和菜单关联
     */
    @PutMapping
    @ApiOperation("根据id修改系统角色和菜单关联")
    public ResponseResult<TSystemRoleMenu> editById(@RequestBody @Valid TSystemRoleMenu tSystemRoleMenu) {
        return ResponseResult.success(systemRoleMenuService.editById(tSystemRoleMenu));
    }

    /**
     * 根据id删除系统角色和菜单关联
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemRoleMenuService.deleteById(id));
    }

    /**
     * 分页获取系统角色和菜单关联
     *
     * @param pageParam 分页参数
     * @return 分页后的系统角色和菜单关联
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统角色和菜单关联")
    public ResponseResult<Page<TSystemRoleMenu>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemRoleMenuService.getPage(pageParam));
    }

}
