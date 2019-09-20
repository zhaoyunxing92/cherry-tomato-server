/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.core.exception;

import io.github.sunny.cherry.tomato.core.result.Response;

/**
 * 控制器层异常
 *
 * @author zhaoyunxing
 * @date: 2018-06-26 16:41
 */
public class AppControllerException extends AppGlobalException {

    public AppControllerException(Response response) {
        super(response);
    }

    public AppControllerException(Response response, Object... args) {
        super(response, args);
    }
}
