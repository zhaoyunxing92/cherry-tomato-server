/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dubbo.mysql.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 17:37
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encode = bcrypt.encode("123456");
        log.info("encode:{}", encode);
        log.info("encode:{}", encode.length());

        boolean matches = bcrypt.matches("123456", encode);

        log.info("matches:{}", matches);

        PasswordEncoder md5 = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String encode1 = md5.encode("dfdsfdsfdsfgkfjgkfjgkfjgdfkjgdfkgjfdklgjkfldgjdfkgj");


        boolean matches1 = md5.matches("123456", encode1);

        log.info("md5:{}", encode1);
        log.info("matches1:{}", matches1);

    }
}
