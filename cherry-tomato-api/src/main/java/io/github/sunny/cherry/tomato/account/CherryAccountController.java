/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account;

import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.form.CherryAccountForm;
import io.github.sunny.cherry.tomato.account.service.CherryAccountService;
import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

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
     * @param form {@link CherryAccountForm}
     * @return 注册用户信息
     */
    @PreAuthorize("hasRole('add_account')")
    @PostMapping("/register")
    public Response register(@Validated(CherryAccountForm.Register.class) @RequestBody CherryAccountForm form) {
        CherryAccountDto dao = new CherryAccountDto();
        BeanUtils.copyProperties(form, dao);
        return cherryAccountService.register(dao);
    }

    @GetMapping("/hello")
    public Response hello() {
        return ResultUtil.success("ok", "hello");
    }
}
