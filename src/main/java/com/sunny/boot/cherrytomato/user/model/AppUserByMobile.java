package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByMobile extends BaseModel<Long> {
  private static final long serialVersionUID = 205102895509993456L;
  private Long mobile;

  private Long userId;

  public Long getMobile() {
    return mobile;
  }

  public void setMobile(Long mobile) {
    this.mobile = mobile;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}