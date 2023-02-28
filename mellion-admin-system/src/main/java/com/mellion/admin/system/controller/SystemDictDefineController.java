package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.entity.TSystemDictDefine;
import com.mellion.admin.system.service.SystemDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统字典定义控制器
 *
 * @author MellionPG
 * @date 2023/2/28 11:34
 **/
@RestController
@RequestMapping("/system/dict/define")
@Validated
@Api(tags = "系统模块 - 字典定义接口")
@RequiredArgsConstructor
public class SystemDictDefineController {

    /**
     * 系统字典定义服务
     */
    private final SystemDictService systemDictService;

    /**
     * 根据id获取系统字典定义详情
     *
     * @param id 主键
     * @return 系统字典定义详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统字典定义详情")
    public ResponseResult<TSystemDictDefine> getById(@RequestParam Long id) {
        return ResponseResult.success(systemDictService.getById(id));
    }

    /**
     * 新增系统字典定义
     *
     * @param tSystemDictDefine 系统字典定义
     * @return 系统字典定义
     */
    @PostMapping
    @ApiOperation("新增系统字典定义")
    public ResponseResult<TSystemDictDefine> add(@RequestBody @Valid TSystemDictDefine tSystemDictDefine) {
        return ResponseResult.success(systemDictService.add(tSystemDictDefine));
    }

    /**
     * 根据id修改系统字典定义
     *
     * @param tSystemDictDefine 系统字典定义
     * @return 系统字典定义
     */
    @PutMapping
    @ApiOperation("根据id修改系统字典定义")
    public ResponseResult<TSystemDictDefine> editById(@RequestBody @Valid TSystemDictDefine tSystemDictDefine) {
        return ResponseResult.success(systemDictService.editById(tSystemDictDefine));
    }

    /**
     * 根据id删除系统字典定义
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemDictService.deleteById(id));
    }

    /**
     * 分页获取系统字典定义
     *
     * @param pageParam 分页参数
     * @return 分页后的系统字典定义
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统字典定义")
    public ResponseResult<Page<TSystemDictDefine>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemDictService.getPage(pageParam));
    }

}
