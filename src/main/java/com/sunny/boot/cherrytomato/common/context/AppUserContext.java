package com.sunny.boot.cherrytomato.common.context;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.common.context.AppUserContext
 * @date: 2018-06-08 16:12
 * @des:
 */
public class AppUserContext extends BaseModel<Long> {
  private static final long serialVersionUID = -3040901576313484640L;
  /**
   * 账号
   */
  private String userName;
  /**
   * 昵称
   */
  private String nickName;
  /**
   * 令牌
   */
  private String token;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
