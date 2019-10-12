/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.service.impl;

import io.github.sunny.cherry.tomato.security.service.SecurityEchoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 15:30
 */
@Service
public class SecurityEchoServiceImpl implements SecurityEchoService {

    @Value("${spring.application.name}")
    private String serverName;

    @Override
    public String echo() {

        return serverName;
    }
}
