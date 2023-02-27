package com.mellion.admin.base.interfaces;

/**
 * 响应状态接口
 *
 * @author MellionPG
 * @date 2023/2/27 10:10
 **/
public interface ResponseStatus {

    /**
     * 获取状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 获取状态信息
     *
     * @return 状态信息
     */
    String getMsg();

}
