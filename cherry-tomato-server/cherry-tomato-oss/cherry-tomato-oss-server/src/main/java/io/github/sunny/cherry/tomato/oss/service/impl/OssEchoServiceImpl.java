/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.oss.service.impl;

import io.github.sunny.cherry.tomato.oss.service.OssEchoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 15:22
 */
@Service
public class OssEchoServiceImpl implements OssEchoService {

    @Value("${spring.application.name}")
    private String serverName;

    @Override
    public String echo() {

        return serverName;
    }
}
