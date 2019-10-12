/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.cache.service.impl;

import io.github.sunny.cherry.tomato.cache.service.CacheEchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 13:50
 */
@Service
public class CacheEchoServiceImpl implements CacheEchoService {

    @Override
    public String echo() {

        return "cache service";
    }
}
