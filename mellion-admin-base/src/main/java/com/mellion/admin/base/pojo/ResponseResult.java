package com.mellion.admin.base.pojo;

import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.interfaces.ResponseStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 统一响应结果对象，封装响应结果
 *
 * @param <T> 响应数据的类型
 * @author MellionPG
 * @date 2023/2/27 9:58
 **/
@Data
@Builder
@ApiModel("请求响应结果")
public class ResponseResult<T> implements Serializable {

    /**
     * 响应状态码
     */
    @ApiModelProperty("响应状态码")
    private Integer code;

    /**
     * 响应消息
     */
    @ApiModelProperty("响应消息")
    private String msg;

    /**
     * 响应具体数据
     */
    @ApiModelProperty("响应具体数字")
    private T data;

    /**
     * 响应数据含有的字典数据，通过切面自动注入
     */
    @ApiModelProperty("字典数据")
    private Map<String, Map<String, String>> dict;

    /**
     * 封装请求成功但不附带数据的结果对象
     *
     * @param <T> 数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    /**
     * 封装请求成功的结果对象
     *
     * @param data 具体数据
     * @param <T>  数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().code(BaseResponseStatus.SUCCESS.getCode())
                .msg(BaseResponseStatus.SUCCESS.getMsg())
                .data(data)
                .build();
    }

    /**
     * 封装请求失败的结果对象：默认code、msg，无data
     *
     * @param <T> 数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> failure() {
        return ResponseResult.<T>builder().code(BaseResponseStatus.FAILURE.getCode())
                .msg(BaseResponseStatus.FAILURE.getMsg())
                .data(null)
                .build();
    }

    /**
     * 封装请求失败的结果对象：默认code，指定msg，无data
     *
     * @param msg 响应提示消息
     * @param <T> 数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> failure(String msg) {
        return ResponseResult.<T>builder().code(BaseResponseStatus.FAILURE.getCode())
                .msg(msg)
                .data(null)
                .build();
    }

    /**
     * 封装请求失败的结果对象：指定code、msg，无data
     *
     * @param code 响应状态码
     * @param msg  响应提示消息
     * @param <T>  数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> failure(Integer code, String msg) {
        return ResponseResult.<T>builder().code(code)
                .msg(msg)
                .data(null)
                .build();
    }

    /**
     * 封装请求失败的结果对象：指定code、msg(枚举类)，无data
     *
     * @param responseStatus 响应状态枚举类
     * @param <T>            数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> failure(ResponseStatus responseStatus) {
        return ResponseResult.<T>builder().code(responseStatus.getCode())
                .msg(responseStatus.getMsg())
                .data(null)
                .build();
    }

    /**
     * 封装请求失败的结果对象：默认code，指定msg、data
     *
     * @param msg  响应提示消息
     * @param data 错误数据
     * @param <T>  数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> failure(String msg, T data) {
        return ResponseResult.<T>builder().code(BaseResponseStatus.FAILURE.getCode())
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 封装请求失败的结果对象：指定code、msg、data
     *
     * @param code 响应状态码
     * @param msg  响应提示消息
     * @param data 错误数据
     * @param <T>  数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> failure(Integer code, String msg, T data) {
        return ResponseResult.<T>builder().code(code)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 封装请求失败的结果对象：指定code(枚举类)、msg(枚举类)、data
     *
     * @param responseStatus 响应状态枚举类
     * @param data           错误数据
     * @param <T>            数据对应的类
     * @return 响应结果
     */
    public static <T> ResponseResult<T> failure(ResponseStatus responseStatus, T data) {
        return ResponseResult.<T>builder().code(responseStatus.getCode())
                .msg(responseStatus.getMsg())
                .data(data)
                .build();
    }

}
