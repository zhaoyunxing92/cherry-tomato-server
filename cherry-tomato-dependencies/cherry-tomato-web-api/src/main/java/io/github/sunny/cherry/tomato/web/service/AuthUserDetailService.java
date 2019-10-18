/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.service;

import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.service.CherryAccountService;
import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.security.service.CherryAccountPermissionsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * 用户认证服务
 *
 * @author zhaoyunxing
 * @date: 2019-10-18 10:47
 */
@Service
public class AuthUserDetailService implements UserDetailsService {

    @Reference
    private CherryAccountService cherryAccountService;
    @Reference
    private CherryAccountPermissionsService cherryAccountPermissionsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Response<CherryAccountDto> account = cherryAccountService.findAccountByUserName(username);

        if (account.isSuccess() && account.hasData()) {
            CherryAccountDto dto = account.getData();
            Response<Set<String>> permissions = cherryAccountPermissionsService.getPermissions(dto.getId());
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            permissions.getData().forEach(power -> authorities.add(new SimpleGrantedAuthority(power)));
            return new User(dto.getUserName(), dto.getPassword(), dto.getEnabled(), dto.getAccountNonExpired(), true, dto.getAccountNonLocked(), authorities);
        } else {
            throw new UsernameNotFoundException(String.format("该用户[%s]不存在！", username));
        }
    }
}
