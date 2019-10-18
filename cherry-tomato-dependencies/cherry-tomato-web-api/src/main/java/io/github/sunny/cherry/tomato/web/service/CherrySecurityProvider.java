/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.service;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyunxing
 * @date: 2019-10-18 13:28
 */
@Service
public class CherrySecurityProvider implements AuthenticationProvider {

    private final UserDetailsService authUserDetailService;

    public CherrySecurityProvider(UserDetailsService authUserDetailService) {this.authUserDetailService = authUserDetailService;}

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();

        UserDetails userDetails = null;
        if (username != null) {
            userDetails = authUserDetailService.loadUserByUsername(username);
        }

        if (userDetails == null) {
            throw new UsernameNotFoundException("用户名/密码无效");
        } else if (!userDetails.isEnabled()) {
            throw new DisabledException(String.format("账号[%s]已被禁用", username));
        } else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException(String.format("账号[%s]已过期", username));
        } else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException(String.format("账号[%s]已被锁定", username));
        } else if (!userDetails.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(String.format("账号[%s]凭证已过期", username));
        }

        String password = userDetails.getPassword();
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if (!bcrypt.matches(token.getCredentials().toString(), password)) {
            throw new BadCredentialsException("用户名或密码错误");
        }
        //授权
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
