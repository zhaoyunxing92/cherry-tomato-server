/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.core.utils;

import io.github.sunny.cherry.tomato.core.result.Response;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 17:15
 */
public class ResultUtil {

    private ResultUtil() {
    }

    public static Response error(Integer code, String msg) {
        return new Response<>(code, msg, null, false);
    }

    public static <T extends Response> T success(Integer code, String msg, Object obj) {
        return (T) new Response<>(code, msg, obj, true);
    }
}
