/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.controller;

import io.github.sunny.cherry.tomato.cache.service.CacheEchoService;
import io.github.sunny.cherry.tomato.oss.service.OssEchoService;
import io.github.sunny.cherry.tomato.security.service.SecurityEchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 14:09
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    @Reference
    private CacheEchoService cacheEchoService;
    @Reference
    private OssEchoService ossEchoService;
    @Reference
    private SecurityEchoService securityEchoService;


    @GetMapping
    private List<String> cache() {
        String cache = cacheEchoService.echo();
        String security = securityEchoService.echo();
        String oss = ossEchoService.echo();

        List<String> services = new ArrayList<>();

        services.add(cache);
        services.add(oss);
        services.add(security);
        return services;
    }
}
