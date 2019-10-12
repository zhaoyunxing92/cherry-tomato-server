/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.handler;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
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
    public Response rpcException(RpcException ex) {
        return ResultUtil.error(500, ex.getMessage());
    }

}
