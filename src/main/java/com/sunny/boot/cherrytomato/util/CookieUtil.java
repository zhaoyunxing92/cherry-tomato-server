/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.util.CookieUtil
 * @date: 2018-06-12 0:40
 * @des: cookie操作
 */
public class CookieUtil {
  private CookieUtil() {
  }

  /**
   * 设置cookie，主要用于登录后设置token
   *
   * @param res
   * @param key 键
   * @param val 值
   */
  public static void setCookie(HttpServletResponse res, String key, String val) {
    Cookie cookie = new Cookie(key, val);
    cookie.setPath("/");
    res.addCookie(cookie);
  }

  /**
   * 读取cookie，主要用于登录后设置token
   *
   * @param req
   * @param key 键
   */
  public static Cookie getCookie(HttpServletRequest req, String key) {

    for (Cookie cookie : req.getCookies()) {
      if (key.equals(cookie.getName())) {
        return cookie;
      }
    }
    return null;
  }
}
