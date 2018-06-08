package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByEmail extends BaseModel<String> {
  private static final long serialVersionUID = -2539760369924185128L;
  private String email;

  private Long userId;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email == null ? null : email.trim();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}