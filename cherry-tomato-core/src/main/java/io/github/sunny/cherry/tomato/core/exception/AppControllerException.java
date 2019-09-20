/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.core.exception;

import com.sunny.boot.cherrytomato.common.result.Response;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.core.exception.AppControllerException
 * @date: 2018-06-26 16:41
 * @des: 控制器层异常
 */
public class AppControllerException extends AppGlobalException {
    public AppControllerException(Response.Result result) {
        super(result);
    }
    public AppControllerException(Response.Result result, Object... args) {
        super(result, args);
    }
}
