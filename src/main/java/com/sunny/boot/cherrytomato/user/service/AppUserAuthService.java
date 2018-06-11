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
   * 邮箱是否存在
   *
   * @param email 邮箱
   * @return
   */
  boolean emailIsExist(String email);

  /**
   * 用户名是否存在
   *
   * @param userName 用户名
   * @return
   */
  boolean userNameIsExist(String userName);

  /**
   * 根据用户名、邮箱注册
   *
   * @param res
   * @param form
   * @return
   */
  Response register(HttpServletResponse res, UserForm form);
}
