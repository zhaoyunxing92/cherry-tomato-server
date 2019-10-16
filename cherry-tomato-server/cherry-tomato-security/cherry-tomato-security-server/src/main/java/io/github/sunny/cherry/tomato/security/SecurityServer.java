/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 15:39
 */
@SpringBootApplication
@MapperScan("io.github.sunny.cherry.tomato.security.mapper")
public class SecurityServer {
    public static void main(String[] args) {
        SpringApplication.run(SecurityServer.class, args);
    }
}
