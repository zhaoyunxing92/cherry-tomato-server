/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

import java.util.Date;

public class AppUser extends BaseModel<Long> {
  /**
   * 账户
   */
  private String username;

  /**
   * 密码
   */
  private String password;

  /**
   * 简介
   */
  private String intro;

  /**
   * 邮箱
   */
  private String email;

  /**
   * 手机号码
   */
  private Long mobile;

  /**
   * 用户头像
   */
  private String avatar;

  /**
   * 性别(0=未知，1=男，2=女)
   */
  private Byte sex;

  /**
   * 账号状态(0=未激活，1=正常，8=冻结)
   */
  private Byte status;

  /**
   * app_user
   */
  private static final long serialVersionUID = 1L;

  /**
   * 账户
   *
   * @return username 账户
   */
  public String getUsername() {
    return username;
  }

  /**
   * 账户
   *
   * @param username 账户
   */
  public void setUsername(String username) {
    this.username = username == null ? null : username.trim();
  }

  /**
   * 密码
   *
   * @return password 密码
   */
  public String getPassword() {
    return password;
  }

  /**
   * 密码
   *
   * @param password 密码
   */
  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  /**
   * 简介
   *
   * @return intro 简介
   */
  public String getIntro() {
    return intro;
  }

  /**
   * 简介
   *
   * @param intro 简介
   */
  public void setIntro(String intro) {
    this.intro = intro == null ? null : intro.trim();
  }

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
   * 手机号码
   *
   * @return mobile 手机号码
   */
  public Long getMobile() {
    return mobile;
  }

  /**
   * 手机号码
   *
   * @param mobile 手机号码
   */
  public void setMobile(Long mobile) {
    this.mobile = mobile;
  }

  /**
   * 用户头像
   *
   * @return avatar 用户头像
   */
  public String getAvatar() {
    return avatar;
  }

  /**
   * 用户头像
   *
   * @param avatar 用户头像
   */
  public void setAvatar(String avatar) {
    this.avatar = avatar == null ? null : avatar.trim();
  }

  /**
   * 性别(0=未知，1=男，2=女)
   *
   * @return sex 性别(0=未知，1=男，2=女)
   */
  public Byte getSex() {
    return sex;
  }

  /**
   * 性别(0=未知，1=男，2=女)
   *
   * @param sex 性别(0=未知，1=男，2=女)
   */
  public void setSex(Byte sex) {
    this.sex = sex;
  }

  /**
   * 账号状态(0=未激活，1=正常，8=冻结)
   *
   * @return status 账号状态(0=未激活，1=正常，8=冻结)
   */
  public Byte getStatus() {
    return status;
  }

  /**
   * 账号状态(0=未激活，1=正常，8=冻结)
   *
   * @param status 账号状态(0=未激活，1=正常，8=冻结)
   */
  public void setStatus(Byte status) {
    this.status = status;
  }

}