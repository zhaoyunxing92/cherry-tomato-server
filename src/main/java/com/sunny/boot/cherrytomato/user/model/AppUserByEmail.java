/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByEmail extends BaseModel<String> {
  /**
   * 邮箱
   */
  private String email;

  /**
   * 用户ID
   */
  private Long userId;

  /**
   * app_user_by_email
   */
  private static final long serialVersionUID = 1L;

  /**
   * 邮箱
   *
   * @return email 邮箱
   */
  public String getEmail() {
    return email;
  }

  /**
   * 邮箱
   *
   * @param email 邮箱
   */
  public void setEmail(String email) {
    this.email = email == null ? null : email.trim();
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