/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByMobile extends BaseModel<Long> {
  /**
   * 手机号
   */
  private Long mobile;

  /**
   * 用户ID
   */
  private Long userId;

  /**
   * app_user_by_mobile
   */
  private static final long serialVersionUID = 1L;

  /**
   * 手机号
   *
   * @return mobile 手机号
   */
  public Long getMobile() {
    return mobile;
  }

  /**
   * 手机号
   *
   * @param mobile 手机号
   */
  public void setMobile(Long mobile) {
    this.mobile = mobile;
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