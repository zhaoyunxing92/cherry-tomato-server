/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.core.exception;

import io.github.sunny.cherry.tomato.core.result.Response;

/**
 * 服务模块异常
 *
 * @author zhaoyunxing
 * @date: 2018-06-26 16:33
 */
public class AppServiceException extends AppGlobalException {

    public AppServiceException(Response response) {
        super(response);
    }

    public AppServiceException(Response response, Object... args) {
        super(response, args);
    }
}
