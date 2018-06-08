package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUser extends BaseModel<Long> {

  private static final long serialVersionUID = -1470400462963501819L;
  
  private String username;

  private String password;

  private String intro;

  private String email;

  private Long mobile;

  private String avatar;

  private Boolean sex;

  private Byte status;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username == null ? null : username.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro == null ? null : intro.trim();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email == null ? null : email.trim();
  }

  public Long getMobile() {
    return mobile;
  }

  public void setMobile(Long mobile) {
    this.mobile = mobile;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar == null ? null : avatar.trim();
  }

  public Boolean getSex() {
    return sex;
  }

  public void setSex(Boolean sex) {
    this.sex = sex;
  }

  public Byte getStatus() {
    return status;
  }

  public void setStatus(Byte status) {
    this.status = status;
  }
}