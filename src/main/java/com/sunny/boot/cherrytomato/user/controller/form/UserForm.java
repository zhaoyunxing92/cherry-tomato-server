package com.sunny.boot.cherrytomato.user.controller.form;


import com.sunny.boot.cherrytomato.user.controller.form.valid.LoginGroup;
import com.sunny.boot.cherrytomato.user.controller.form.valid.RegisterGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
  @NotEmpty(message = "请输入用户名", groups = {LoginGroup.class})
  private String userName;
  /**
   * 密码
   */
  @NotNull(message = "字段【password】必填", groups = {LoginGroup.class, RegisterGroup.class})
  @NotEmpty(message = "请输入密码", groups = {LoginGroup.class, RegisterGroup.class})
  @Length(min = 6, max = 15, message = "请输入{min}~{max}字符的密码", groups = {RegisterGroup.class})
  private String password;
  /**
   * 邮箱
   */
  @NotNull(message = "字段【email】必填", groups = { RegisterGroup.class})
  @NotEmpty(message = "请输入邮箱", groups = {RegisterGroup.class})
  @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", message = "请输入正确的邮箱", groups = {RegisterGroup.class})
  @Length(min = 5, max = 50, message = "请输入{min}~{max}字符的邮箱", groups = {RegisterGroup.class})
  private String email;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
