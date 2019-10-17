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

    public static <T extends Response> T error(String msg, String url, Object data) {
        return (T) new Response<>(msg, url, data, false);
    }

    public static <T extends Response> T error(String msg, String url) {
        return error(msg, url, null);
    }

    public static <T extends Response> T error(String msg) {
        return error(msg, null, null);
    }

    public static <T extends Response> T success(String msg, Object obj) {
        return (T) new Response<>(msg, null, obj, true);
    }

    public static <T extends Response> T success(String msg) {
        return success(msg, null);
    }
}
