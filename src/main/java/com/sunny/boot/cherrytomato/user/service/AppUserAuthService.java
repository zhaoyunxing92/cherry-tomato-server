/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.service;

import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.user.controller.form.UserForm;

import javax.servlet.http.HttpServletResponse;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.user.service.AppUserAuthService
 * @date: 2018-06-11 9:30
 * @des: app用户认证服务
 */
public interface AppUserAuthService {
  /**
   * 根据用户名密码登录
   *
   * @param res
   * @param userName 用户名/邮箱/手机号
   * @param password 密码
   * @return
   */
  Response login(HttpServletResponse res, String userName, String password);

  /**
   * 根据邮箱和密码注册
   *
   * @param res
   * @param email
   * @param password
   * @return
   */
  Response registerByEmail(HttpServletResponse res, String email, String password);

  /**
   * 邮箱是否存在
   *
   * @param email
   * @return
   */
  boolean emailIsExist(String email);
}
