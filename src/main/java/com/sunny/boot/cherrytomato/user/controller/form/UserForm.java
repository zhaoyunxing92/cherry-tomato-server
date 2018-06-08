package com.sunny.boot.cherrytomato.user.controller.form;


import com.sunny.boot.cherrytomato.user.controller.form.valid.LoginGroup;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.user.controller.form.UserForm
 * @date: 2018-06-08 16:51
 * @des:
 */
public class UserForm {
  /**
   * 用户名
   */
  @NotNull(message = "字段【userName】必填", groups = {LoginGroup.class})
  @NotEmpty(message = "请输入用户名")
  private String userName;
  /**
   * 密码
   */
  private String password;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
