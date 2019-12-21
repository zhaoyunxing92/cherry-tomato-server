/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.handler;

import io.github.sunny.cherry.tomato.core.exception.AppGlobalException;
import io.github.sunny.cherry.tomato.core.result.Response;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
    public Response<?> rpcException(RpcException ex) {
        return Response.error(500, ex.getMessage());
    }
    /**
     * rpc 调用异常
     *
     * @param ex RpcException
     * @return 异常信息
     */
    @ExceptionHandler(value = RuntimeException.class)
    public Response<?> runException(RuntimeException ex) {
        System.out.println(555);
        return Response.error(500, ex.getMessage());
    }
    /**
     * rpc 调用异常
     *
     * @param ex RpcException
     * @return 异常信息
     */
    @ExceptionHandler(value = AppGlobalException.class)
    public Response<?> appGlobalException(AppGlobalException ex) {
        return ex.getResponse();
    }
}
