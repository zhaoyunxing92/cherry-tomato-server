/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.controller;

import io.github.sunny.cherry.tomato.cache.service.CacheEchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 14:09
 */
@RestController
@RequestMapping("/")
public class EchoController {

    @Reference
    private CacheEchoService cacheEchoService;

    @GetMapping("/cache")
    private String cache() {
        return cacheEchoService.echo();
    }
}
