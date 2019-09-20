/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.core.exception;

import com.sunny.boot.cherrytomato.common.result.Response;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.core.exception.AppServiceException
 * @date: 2018-06-26 16:33
 * @des: 服务模块异常
 */
public class AppServiceException extends AppGlobalException {
    public AppServiceException(Response.Result result) {
        super(result);
    }

    public AppServiceException(Response.Result result, Object... args) {
        super(result, args);
    }
}
