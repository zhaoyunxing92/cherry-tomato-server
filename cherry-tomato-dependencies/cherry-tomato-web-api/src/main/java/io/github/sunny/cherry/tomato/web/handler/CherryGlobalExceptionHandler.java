/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.handler;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常统一处理
 *
 * @author zhaoyunxing
 * @date: 2019-10-12 16:59
 */
@RestControllerAdvice
public class CherryGlobalExceptionHandler {
    /**
     * rpc 调用异常
     *
     * @param ex RpcException
     * @return 异常信息
     */
    @ExceptionHandler(value = RpcException.class)
    public Response rpcException(HttpServletRequest request, RpcException ex) {

        if (ex.isTimeout()) {
            return ResultUtil.error("remote invoke timeout exception", request.getRequestURL().toString(), ex.getMessage());
        } else if (ex.isSerialization()) {
            return ResultUtil.error("remote serialized exception", request.getRequestURL().toString(), ex.getMessage());
        } else if (ex.isNetwork()) {
            return ResultUtil.error("remote network exception", request.getRequestURL().toString(), ex.getMessage());
        } else if (ex.isNoInvokerAvailableAfterFilter()) {
            return ResultUtil.error("remote no started exception", request.getRequestURL().toString(), ex.getMessage());
        }
        return ResultUtil.error("remote call exception", request.getRequestURL().toString(), ex.getMessage());
    }

    /**
     * 唯一键重复异常
     *
     * @param ex DuplicateKeyException
     * @return 异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public Response exception(HttpServletRequest request, Exception ex) {
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            return ResultUtil.error("request method not supported", request.getRequestURL().toString(), ex.getMessage());
        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException argumentNotValidException = (MethodArgumentNotValidException) ex;
            String msg = argumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
            return ResultUtil.error("argument not valid exception", request.getRequestURL().toString(), msg);
        } else if (ex instanceof HttpMessageNotReadableException) {
            // 请求体为空异常
            HttpMessageNotReadableException notReadableException = (HttpMessageNotReadableException) ex;
            String msg = notReadableException.getMessage();
            return ResultUtil.error("not readable exception", request.getRequestURL().toString(), msg);
        }
        return ResultUtil.error("system exception", request.getRequestURL().toString(), ex.getMessage());
    }
}
