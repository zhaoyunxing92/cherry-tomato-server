/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByUsername extends BaseModel<String> {
  /**
   * 账号
   */
  private String username;

  /**
   * 用户ID
   */
  private Long userId;

  /**
   * app_user_by_username
   */
  private static final long serialVersionUID = 1L;

  /**
   * 账号
   *
   * @return username 账号
   */
  public String getUsername() {
    return username;
  }

  /**
   * 账号
   *
   * @param username 账号
   */
  public void setUsername(String username) {
    this.username = username == null ? null : username.trim();
  }

  /**
   * 用户ID
   *
   * @return userId 用户ID
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * 用户ID
   *
   * @param userId 用户ID
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }
}