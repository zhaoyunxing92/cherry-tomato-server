/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

/**
 * spring security 配置文件
 *
 * @author zhaoyunxing
 * @date: 2019-10-18 16:21
 */
@Configuration
@EnableWebSecurity
public class CherrySpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationProvider cherrySpringSecurityProvider;
    private final UserDetailsService authUserDetailService;

    public CherrySpringSecurityConfig(AuthenticationProvider cherrySpringSecurityProvider, UserDetailsService authUserDetailService) {
        this.cherrySpringSecurityProvider = cherrySpringSecurityProvider;
        this.authUserDetailService = authUserDetailService;
    }

    /**
     * 跨域设置
     *
     * @return CorsConfigurationSource
     */
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**").fullyAuthenticated()
                .antMatchers("/login").permitAll()
                .and().oauth2Login();
        http.cors().configurationSource(corsConfigurationSource());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(cherrySpringSecurityProvider);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this.authUserDetailService;
    }
}
