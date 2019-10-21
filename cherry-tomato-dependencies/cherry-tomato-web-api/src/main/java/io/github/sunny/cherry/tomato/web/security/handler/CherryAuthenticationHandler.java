/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.security.handler;

import com.alibaba.fastjson.JSONObject;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录认证处理器
 *
 * @author zhaoyunxing
 * @date: 2019-10-19 17:36
 */
@Component
public class CherryAuthenticationHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler, AuthenticationEntryPoint, AccessDeniedHandler, LogoutSuccessHandler {
    /**
     * 登录成功
     *
     * @param req
     * @param res
     * @param auth
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setContentType("application/json;charset=utf-8");
        res.setStatus(HttpStatus.OK.value());

        res.getWriter().write(JSONObject.toJSONString(ResultUtil.success("登录成功", auth.getPrincipal())));
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException ex) throws IOException, ServletException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setContentType("application/json;charset=utf-8");
        res.setStatus(HttpStatus.OK.value());

        res.getWriter().write(JSONObject.toJSONString(ResultUtil.error(ex.getMessage())));
    }

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException ex) throws IOException, ServletException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setContentType("application/json;charset=utf-8");
        res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        res.getWriter().write(JSONObject.toJSONString(ResultUtil.error(ex.getMessage())));
    }

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException ex) throws IOException, ServletException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setContentType("application/json;charset=utf-8");
        res.setStatus(HttpStatus.FORBIDDEN.value());

        res.getWriter().write(JSONObject.toJSONString(ResultUtil.error(ex.getMessage())));
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "*");
        res.setContentType("application/json;charset=utf-8");
        res.setStatus(HttpStatus.OK.value());

        res.getWriter().write(JSONObject.toJSONString(ResultUtil.success("退出成功")));
    }
}
