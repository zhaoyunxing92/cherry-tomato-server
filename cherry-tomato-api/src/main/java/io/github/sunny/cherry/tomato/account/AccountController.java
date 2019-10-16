/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account;

import io.github.sunny.cherry.tomato.core.result.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 10:14
 */
@RestController
@RequestMapping("/")
public class AccountController {

    @PostMapping("/register")
    public Response register(){
        return null;
    }
}
