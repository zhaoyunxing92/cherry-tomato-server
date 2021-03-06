/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.cache.service.impl;

import io.github.sunny.cherry.tomato.cache.service.CacheEchoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 13:50
 */
@Service
public class CacheEchoServiceImpl implements CacheEchoService {

    @Value("${spring.application.name}")
    private String serverName;

    @Override
    public String echo() {

        return serverName;
    }
}
