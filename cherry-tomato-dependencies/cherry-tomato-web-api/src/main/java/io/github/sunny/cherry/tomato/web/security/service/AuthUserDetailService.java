/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.security.service;

import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.service.CherryAccountService;
import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.security.service.CherryAccountPermissionsService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.remoting.RemotingException;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用户认证服务
 * 实现{@link UserDetailsService}加载用户信息
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
        if (!StringUtils.hasText(username)) {
            return null;
        }
        try {
            Response<CherryAccountDto> account = cherryAccountService.findAccountByUserName(username);

            if (account.isSuccess() && account.hasData()) {
                CherryAccountDto dto = account.getData();
                // 用户权限
                Response<List<String>> permissions = cherryAccountPermissionsService.getPermissions(dto.getId());

                // 可以不用去重 new User(...) 已经去除重复 Collections.unmodifiableSet(sortAuthorities(authorities))
                List<GrantedAuthority> authorities = permissions.getData().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

                return new User(dto.getUserName(), dto.getPassword(), dto.getEnabled(), dto.getAccountNonExpired(), true, dto.getAccountNonLocked(), authorities);
            } else {
                throw new UsernameNotFoundException(String.format("该用户[%s]不存在！", username));
            }
        } catch (Exception ex) {
            if (ex instanceof RpcException) {
                throw new RpcException(ex.getMessage());
            } else {
                throw new RemoteAccessException(ex.getMessage());
            }
        }
    }
}
