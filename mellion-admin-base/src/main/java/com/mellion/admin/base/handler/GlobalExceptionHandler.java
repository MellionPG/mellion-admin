package com.mellion.admin.base.handler;

import com.mellion.admin.base.enums.BaseResponseStatus;
import com.mellion.admin.base.exception.ServiceException;
import com.mellion.admin.base.pojo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import javax.xml.bind.ValidationException;

/**
 * 全局异常处理器
 *
 * @author MellionPG
 * @date 2023/2/27 10:25
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常日志输出格式
     */
    private final static String EXCEPTION_LOG_FORMAT = "exception:{}, message:{}";

    /**
     * 请求方法不允许405异常处理
     *
     * @param e 请求方法不允许异常
     * @return 响应结果
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseResult<Object> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error(EXCEPTION_LOG_FORMAT, e.getClass(), e.getMessage(), e);
        String exceptionDetail = "异常类型：" + e.getClass() + "；异常消息：" + e.getMessage();
        return ResponseResult.failure(BaseResponseStatus.METHOD_NOT_SUPPORTED, exceptionDetail);
    }

    /**
     * Servlet异常处理
     *
     * @param e 请求绑定错误异常
     * @return 响应结果
     */
    @ExceptionHandler(ServletException.class)
    public ResponseResult<String> handleServletException(ServletException e) {
        log.error(EXCEPTION_LOG_FORMAT, e.getClass(), e.getMessage(), e);
        String exceptionDetail = "异常类型：" + e.getClass() + "；异常消息：" + e.getMessage();
        return ResponseResult.failure(BaseResponseStatus.SERVLET_EXCEPTION, exceptionDetail);
    }

    /**
     * 参数校验失败异常处理
     *
     * @param e 参数校验失败异常
     * @return 响应结果
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseResult<String> handleValidationException(ValidationException e) {
        log.error(EXCEPTION_LOG_FORMAT, e.getClass(), e.getMessage(), e);
        String exceptionDetail = "异常类型：" + e.getClass() + "；异常消息：" + e.getMessage();
        return ResponseResult.failure(BaseResponseStatus.VALIDATION_EXCEPTION, exceptionDetail);
    }

    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return 响应结果
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseResult<String> handleServiceException(ServiceException e) {
        log.error(EXCEPTION_LOG_FORMAT, e.getClass(), e.getMessage(), e);
        String exceptionDetail = "异常类型：" + e.getClass() + "；异常消息：" + e.getMessage();
        return ResponseResult.failure(e.getCode(), e.getMsg(), exceptionDetail);
    }

    /**
     * 默认全局异常处理
     *
     * @param e 异常
     * @return 响应结果
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<String> handleException(Exception e) {
        log.error(EXCEPTION_LOG_FORMAT, e.getClass(), e.getMessage(), e);
        String exceptionDetail = "异常类型：" + e.getClass() + "；异常消息：" + e.getMessage();
        return ResponseResult.failure(BaseResponseStatus.FAILURE, exceptionDetail);
    }

}
