package com.sunny.boot.cherrytomato.core.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sunny.boot.cherrytomato.common.result.Response;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.interceptor.AppGlobalHandlerInterceptor
 * @date: 2018-06-08 13:54
 * @des: 全局拦截器
 */
public class AppGlobalHandlerInterceptor implements HandlerInterceptor {
  //private static final String[] EXCLUDES = {"/swagger-resources", "/configuration/security", "/v2/api-docs", "/configuration/ui", "/auth/login", "/error"};
  private static final String[] EXCLUDES = {"/auth/login", "/auth/reg", "/error"};

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String path = request.getServletPath();

    if (isInterceptor(path)) {
      response.setContentType("application/json; charset=utf-8");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write(Response.Result.NOT_LOGIN_ERROR.toString());
      return false;
    } else {
      return true;
    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }

  /**
   * 是否拦截path ,默认都拦截
   *
   * @param path
   * @return
   */
  private boolean isInterceptor(String path) {
    for (String exclude : EXCLUDES) {
      if (path.startsWith(exclude)) {
        return false;
      }
    }
    return true;
  }
}
