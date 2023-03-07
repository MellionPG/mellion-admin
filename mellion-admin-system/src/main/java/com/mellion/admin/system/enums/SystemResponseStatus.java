package com.mellion.admin.system.enums;

import com.mellion.admin.base.interfaces.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统模块的响应枚举类
 *
 * @author MellionPG
 * @date 2023/3/6 16:35
 **/
@Getter
@AllArgsConstructor
public enum SystemResponseStatus implements ResponseStatus {

    /**
     * 登录失败，账号密码错误
     */
    LOGIN_BAD_CREDENTIALS(2001, "登录失败，账号密码错误"),

    /**
     * 登录失败，用户密码未设置
     */
    PASSWORD_NOT_SET(2002, "登录失败，用户密码未设置"),

    /**
     * 登录失败，账号被禁用
     */
    LOGIN_USER_DISABLED(2003, "登录失败，账号被禁用");

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String msg;

}
