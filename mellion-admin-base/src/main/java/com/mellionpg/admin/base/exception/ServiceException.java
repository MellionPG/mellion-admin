package com.mellionpg.admin.base.exception;

import com.mellionpg.admin.base.enums.BaseResponseStatus;
import com.mellionpg.admin.base.interfaces.ResponseStatus;
import lombok.Getter;

/**
 * 自定义业务异常类
 *
 * @author MellionPG
 * @date 2023/2/27 10:28
 **/
@Getter
public class ServiceException extends RuntimeException {

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String msg;

    public ServiceException() {
        this(BaseResponseStatus.FAILURE);
    }

    public ServiceException(String msg) {
        this(BaseResponseStatus.FAILURE.getCode(), msg);
    }

    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(ResponseStatus responseStatus) {
        super(responseStatus.getMsg());
        this.code = responseStatus.getCode();
        this.msg = responseStatus.getMsg();
    }

}
