/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account;

import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.service.CherryAccountService;
import io.github.sunny.cherry.tomato.core.result.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * cherry 账户模块
 *
 * @author zhaoyunxing
 * @date: 2019-10-16 10:14
 */
@RestController
@RequestMapping("/")
public class CherryAccountController {

    @Reference
    private CherryAccountService cherryAccountService;

    /**
     * 注册账户，分配普通权限
     *
     * @param form {@link CherryAccountDto}
     * @return 注册用户信息
     */
    @PostMapping("/register")
    public Response register(@RequestBody CherryAccountDto form) {
        return cherryAccountService.register(form);
    }
}
