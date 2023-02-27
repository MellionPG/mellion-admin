package com.mellionpg.admin.base.enums;

import com.mellionpg.admin.base.interfaces.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 基础响应状态枚举类
 *
 * @author MellionPG
 * @date 2023/2/27 10:05
 **/
@Getter
@AllArgsConstructor
public enum BaseResponseStatus implements ResponseStatus {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 服务器异常
     */
    FAILURE(500, "操作失败"),

    /**
     * 请求未授权/认证
     */
    UNAUTHORIZED(401, "请求未授权"),

    /**
     * 请求资源未授权，被拒绝
     */
    REQUEST_FORBIDDEN(403, "请求被拒绝"),

    /**
     * 404，没有对应请求资源
     */
    NOT_FOUND(404, "请求未找到"),

    /**
     * 不支持当前请求方法
     */
    METHOD_NOT_SUPPORTED(405, "不支持当前请求方法"),

    /**
     * 不支持当前媒体类型
     */
    MEDIA_TYPE_NOT_SUPPORTED(415, "不支持当前媒体类型"),

    /**
     * Servlet出现异常
     */
    SERVLET_EXCEPTION(1001, "Servlet出现异常"),

    /**
     * 请求参数校验失败
     */
    VALIDATION_EXCEPTION(1002, "请求参数校验失败"),

    /**
     * 主键ID不能为空
     */
    ID_IS_NULL(1003, "主键ID不能为空"),

    /**
     * 目标数据为空/不存在
     */
    DATA_IS_NULL(1004, "目标数据为空/不存在");

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String msg;

}
