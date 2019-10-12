/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 13:57
 */
@SpringBootApplication
public class CacheServer {

    public static void main(String[] args) {
        SpringApplication.run(CacheServer.class, args);
    }
}
