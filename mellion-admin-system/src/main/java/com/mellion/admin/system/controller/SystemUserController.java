package com.mellion.admin.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mellion.admin.base.pojo.PageParam;
import com.mellion.admin.base.pojo.ResponseResult;
import com.mellion.admin.system.annotation.EnableDictInjection;
import com.mellion.admin.system.entity.TSystemUser;
import com.mellion.admin.system.param.LoginFormRequestParam;
import com.mellion.admin.system.service.SystemUserService;
import com.mellion.admin.system.vo.UserLoginTokenVO;
import com.mellion.admin.system.vo.UserPermissionInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统用户控制器
 *
 * @author MellionPG
 * @date 2023/3/2 16:31
 **/
@RestController
@RequestMapping("/system/user")
@Validated
@Api(tags = "系统模块 - 用户接口")
@RequiredArgsConstructor
@EnableDictInjection
public class SystemUserController {

    /**
     * 系统用户服务
     */
    private final SystemUserService systemUserService;

    /**
     * 根据id获取系统用户详情
     *
     * @param id 主键
     * @return 系统用户详情
     */
    @GetMapping
    @ApiOperation("根据id获取系统用户详情")
    public ResponseResult<TSystemUser> getById(@RequestParam Long id) {
        return ResponseResult.success(systemUserService.getById(id));
    }

    /**
     * 新增系统用户
     *
     * @param tSystemUser 系统用户
     * @return 系统用户
     */
    @PostMapping
    @ApiOperation("新增系统用户")
    public ResponseResult<TSystemUser> add(@RequestBody @Valid TSystemUser tSystemUser) {
        return ResponseResult.success(systemUserService.add(tSystemUser));
    }

    /**
     * 根据id修改系统用户
     *
     * @param tSystemUser 系统用户
     * @return 系统用户
     */
    @PutMapping
    @ApiOperation("根据id修改系统用户")
    public ResponseResult<TSystemUser> editById(@RequestBody @Valid TSystemUser tSystemUser) {
        return ResponseResult.success(systemUserService.editById(tSystemUser));
    }

    /**
     * 根据id删除系统用户
     *
     * @param id 主键
     * @return 删除状态
     */
    @DeleteMapping
    @ApiOperation("根据id删除测试样例")
    public ResponseResult<Boolean> deleteById(@RequestParam Long id) {
        return ResponseResult.success(systemUserService.deleteById(id));
    }

    /**
     * 分页获取系统用户
     *
     * @param pageParam 分页参数
     * @return 分页后的系统用户
     */
    @GetMapping("/page")
    @ApiOperation("分页获取系统用户")
    public ResponseResult<Page<TSystemUser>> getPage(@Valid PageParam pageParam) {
        return ResponseResult.success(systemUserService.getPage(pageParam));
    }

    /**
     * 账号密码登录
     *
     * @param loginForm 登录表单
     * @return 登录结果
     */
    @PostMapping("/login")
    @ApiOperation("账号密码登录")
    public ResponseResult<UserLoginTokenVO> login(@RequestBody @Valid LoginFormRequestParam loginForm) throws NoSuchFieldException {
        return ResponseResult.success(systemUserService.login(loginForm));
    }

    /**
     * 获取用户权限信息
     *
     * @param token 登录令牌
     * @return 权限信息
     */
    @GetMapping("/permission")
    @ApiOperation("获取用户权限信息")
    public ResponseResult<UserPermissionInfoVO> getPermissionInfo(@RequestHeader("Authorization") String token) throws NoSuchFieldException {
        return ResponseResult.success(systemUserService.getPermissionInfo(token));
    }

}
