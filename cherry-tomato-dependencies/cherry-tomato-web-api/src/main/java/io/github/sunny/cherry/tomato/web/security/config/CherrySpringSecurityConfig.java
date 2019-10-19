/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.security.config;

import io.github.sunny.cherry.tomato.web.security.handler.CherryAuthenticationHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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

    private final CherryAuthenticationHandler cherryAuthenticationHandler;

    public CherrySpringSecurityConfig(AuthenticationProvider cherrySpringSecurityProvider, UserDetailsService authUserDetailService, CherryAuthenticationHandler cherryAuthenticationHandler) {
        this.cherrySpringSecurityProvider = cherrySpringSecurityProvider;
        this.authUserDetailService = authUserDetailService;
        this.cherryAuthenticationHandler = cherryAuthenticationHandler;
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
        // 关闭csrf
        http.csrf().disable();
        // 跨域配置
        http.cors().configurationSource(corsConfigurationSource());
        // httpBasic 没有登录会跳出网页登录
        http.httpBasic().authenticationEntryPoint(cherryAuthenticationHandler);
        //必须授权才能范围
        http.authorizeRequests()
                .anyRequest().authenticated();
        // 登录
        http.formLogin() //使用自带的登录
                .loginProcessingUrl("/login")
                .usernameParameter("userName")
                .passwordParameter("password")
                .successHandler(cherryAuthenticationHandler)
                .failureHandler(cherryAuthenticationHandler)
                //.failureForwardUrl("/login")
                .permitAll();
        // 异常拦截
        http.exceptionHandling()
                .accessDeniedHandler(cherryAuthenticationHandler);

        // 退出
        http.logout()
                .invalidateHttpSession(true) // 关闭session
                .logoutSuccessHandler(cherryAuthenticationHandler)
                .permitAll();

        //http.addFilterBefore()

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用cherrySpringSecurityProvider 处理器
        auth.authenticationProvider(cherrySpringSecurityProvider);
    }

    /**
     * options请求忽略
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
