/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author zhaoyunxing
 * @date: 2019-10-17 15:25
 */
@Configuration
@EnableWebSecurity
public class CherrySecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService authUserDetailService;
    private final AuthenticationProvider cherrySecurityProvider;

    public CherrySecurityConfig(UserDetailsService authUserDetailService, AuthenticationProvider cherrySecurityProvider) {
        this.authUserDetailService = authUserDetailService;
        this.cherrySecurityProvider = cherrySecurityProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and();
        //.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //自定义AuthenticationProvider
        auth.authenticationProvider(cherrySecurityProvider);
    }

    @Override
    public UserDetailsService userDetailsService() {
        //  InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // manager.createUser(User.withUsername("sunny").password("123456").roles("USER").build());
        return this.authUserDetailService;
    }
}
