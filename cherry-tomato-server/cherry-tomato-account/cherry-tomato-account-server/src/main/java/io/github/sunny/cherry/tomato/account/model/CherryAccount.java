/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.model;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author sunny
 * @date: 2019-10-16 10:20:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CherryAccount extends BaseModel<Long> {
    /**
     * 账户名称
     */
    private String userName;

    /**
     * 账户邮箱
     */
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
     * 头像地址
     */
    private String avatar;

    /**
     * 账户是否过期：0=过期，1=未过期
     */
    private Boolean accountNonExpired = false;

    /**
     * 账户是否锁定：0=锁定，1=未锁定
     */
    private Boolean accountNonLocked = false;

    /**
     * 是否启用：0=不启用，1=启用
     */
    private Boolean enabled = false;
}