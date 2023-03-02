package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.annotation.EnableDictInjection;
import com.mellion.admin.system.entity.TSystemMenu;
import com.mellion.admin.system.service.SystemMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统菜单控制器
 *
 * @author MellionPG
 * @date 2023/3/2 16:30
 **/
@RestController
@RequestMapping("/system/menu")
@Validated
@Api(tags = "系统模块 - 菜单接口")
@RequiredArgsConstructor
@EnableDictInjection
public class SystemMenuController {

    /**
     * 系统菜单服务
     */
    private final SystemMenuService systemMenuService;

    /**
     * 根据id获取系统菜单详情
     *
     * @param id 主键
     * @return 系统菜单详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统菜单详情")
    public ResponseResult<TSystemMenu> getById(@RequestParam Long id) {
        return ResponseResult.success(systemMenuService.getById(id));
    }

    /**
     * 新增系统菜单
     *
     * @param tSystemMenu 系统菜单
     * @return 系统菜单
     */
    @PostMapping
    @ApiOperation("新增系统菜单")
    public ResponseResult<TSystemMenu> add(@RequestBody @Valid TSystemMenu tSystemMenu) {
        return ResponseResult.success(systemMenuService.add(tSystemMenu));
    }

    /**
     * 根据id修改系统菜单
     *
     * @param tSystemMenu 系统菜单
     * @return 系统菜单
     */
    @PutMapping
    @ApiOperation("根据id修改系统菜单")
    public ResponseResult<TSystemMenu> editById(@RequestBody @Valid TSystemMenu tSystemMenu) {
        return ResponseResult.success(systemMenuService.editById(tSystemMenu));
    }

    /**
     * 根据id删除系统菜单
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemMenuService.deleteById(id));
    }

    /**
     * 分页获取系统菜单
     *
     * @param pageParam 分页参数
     * @return 分页后的系统菜单
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统菜单")
    public ResponseResult<Page<TSystemMenu>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemMenuService.getPage(pageParam));
    }

}
