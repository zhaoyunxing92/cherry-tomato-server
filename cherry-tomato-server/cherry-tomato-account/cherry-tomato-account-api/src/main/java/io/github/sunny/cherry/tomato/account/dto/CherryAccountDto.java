/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.dto;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author sunny
 * @date: 2019-10-16 10:20:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CherryAccountDto extends BaseModel<Long> implements Serializable {
    /**
     * 账户名称
     */
    @NotNull(message = "请输入用户名")
    @Length(max = 30, min = 3, message = "用户名称")
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
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 介绍
     */
    private String intro;

    /**
     * logo地址
     */
    private String avatar;

    /**
     * 账户是否过期：0=过期，1=未过期
     */
    private Boolean accountNonExpired;

    /**
     * 账户是否锁定：0=锁定，1=未锁定
     */
    private Boolean accountNonLocked;

    /**
     * 是否启用：0=不启用，1=启用
     */
    private Boolean enabled;
}