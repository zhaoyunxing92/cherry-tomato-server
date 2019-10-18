/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.model;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author sunny
 * @date: 2019-10-16 10:20:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CherryAccount extends BaseModel<Long> implements UserDetails {
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
     * 昵称
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
    /**
     * 用户权限
     */
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}