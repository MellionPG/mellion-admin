package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.entity.TSystemDictItem;
import com.mellion.admin.system.service.SystemDictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统字典项控制器
 *
 * @author MellionPG
 * @date 2023/2/28 12:11
 **/
@RestController
@RequestMapping("/system/dict/item")
@Validated
@Api(tags = "系统模块 - 字典项接口")
@RequiredArgsConstructor
public class SystemDictItemController {

    /**
     * 系统字典项服务
     */
    private final SystemDictItemService systemDictItemService;

    /**
     * 根据id获取系统字典项详情
     *
     * @param id 主键
     * @return 系统字典项详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统字典项详情")
    public ResponseResult<TSystemDictItem> getById(@RequestParam Long id) {
        return ResponseResult.success(systemDictItemService.getById(id));
    }

    /**
     * 新增系统字典项
     *
     * @param tSystemDictItem 系统字典项
     * @return 系统字典项
     */
    @PostMapping
    @ApiOperation("新增系统字典项")
    public ResponseResult<TSystemDictItem> add(@RequestBody @Valid TSystemDictItem tSystemDictItem) {
        return ResponseResult.success(systemDictItemService.add(tSystemDictItem));
    }

    /**
     * 根据id修改系统字典项
     *
     * @param tSystemDictItem 系统字典项
     * @return 系统字典项
     */
    @PutMapping
    @ApiOperation("根据id修改系统字典项")
    public ResponseResult<TSystemDictItem> editById(@RequestBody @Valid TSystemDictItem tSystemDictItem) {
        return ResponseResult.success(systemDictItemService.editById(tSystemDictItem));
    }

    /**
     * 根据id删除系统字典项
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemDictItemService.deleteById(id));
    }

    /**
     * 分页获取系统字典项
     *
     * @param pageParam 分页参数
     * @return 分页后的系统字典项
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统字典项")
    public ResponseResult<Page<TSystemDictItem>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemDictItemService.getPage(pageParam));
    }


}
