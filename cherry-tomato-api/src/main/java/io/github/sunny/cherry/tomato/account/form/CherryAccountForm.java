/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author zhaoyunxing
 * @date: 2019-10-17 15:44
 */
@Getter
@Setter
public class CherryAccountForm {
    /**
     * 账户名称
     */
    @NotNull(message = "{cherry.api.account.constraints.NotNull.message}", groups = {Login.class, Register.class})
    @Length(max = 30, min = 3, message = "{cherry.api.account.constraints.NotNull.message}", groups = {Register.class})
    private String userName;

    /**
     * 账户邮箱
     */
    @Length(max = 32, min = 5, message = "请输入{min}~{max}长度的邮箱")
    @Pattern(regexp = "([A-Za-z0-9_\\-.\\u4e00-\\u9fa5])+@([A-Za-z0-9_\\-.])+\\.([A-Za-z]{2,8})", message = "邮箱不合法")
    private String email;

    /**
     * 账户密码
     */
    @NotNull(message = "{cherry.api.password.constraints.NotNull.message}", groups = {Login.class, Register.class})
    private String password;

    /**
     * 登录
     */
    public interface Login {
    }

    /**
     * 注册
     */
    public interface Register {
    }
}
