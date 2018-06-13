package com.sunny.boot.cherrytomato.common.result;

import java.io.Serializable;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.common.result.Response
 * @date: 2018-06-06 13:57
 * @des: 统一返回
 */
public class Response<T> implements Serializable {
  private static final long serialVersionUID = 393612537159594290L;
  /**
   * code码
   */
  private Integer code;
  /**
   * 消息
   */
  private String msg;
  /**
   * 数据
   */
  private T data;

  public Response() {
  }

  public Response(Integer code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public Response(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public Response(Response.Result result, T data) {
    this.code = result.getCode();
    this.msg = result.getMsg();
    this.data = data;
  }

  public Response(Response.Result result) {
    this.code = result.getCode();
    this.msg = result.getMsg();
    //this.data = null;
  }

  /**
   * 可以格式化的返回
   *
   * @param result
   * @param args
   */
  public Response(Response.Result result, Object... args) {
    this.code = result.getCode();
    this.msg = String.format(result.getMsg(), args);
    //this.data = null;
  }


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  /**
   * 统一返回结果码
   */
  public enum Result {
    /**
     * 成功
     */
    SUCCESS(0, "成功!"),
    /**
     * 登录成功
     */
    LOGIN_SUCCESS(0, "登录成功"),
    /**
     * 请先登录
     */
    NOT_LOGIN_ERROR(1, "请先登录"),
    /**
     * 签名校验异常
     */
    SIGNATURE_VALIDATION_ERROR(2, "签名校验异常"),
    /**
     * 用户名不存在
     */
    USERNAME_DOES_NOT_EXIST_ERROR(10000, "用户名不存在"),
    /**
     * 用户名称在byxxx表，但是在app_user表不存在
     */
    USERNAME_DOES_NOT_EXIST_IN_APP_USER_ERROR(10001, "用户名不存在"),
    /**
     * 密码错误
     */
    PASSWORD_NOT_EQUALS_ERROR(10002, "密码错误"),
    /**
     * 邮箱已经被注册
     */
    EMAIL_IS_EXIST_ERROR(10003, "该[%s]邮箱已经被注册"),
    /**
     * 用户名已经被注册
     */
    USERNAME_IS_EXIST_ERROR(10004, "该[%s]用户名已经被注册"),;

    private Integer code;
    private String msg;

    Result(Integer code, String msg) {
      this.code = code;
      this.msg = msg;
    }

    public Integer getCode() {
      return code;
    }

    public String getMsg() {
      return msg;
    }

    public void setCode(Integer code) {
      this.code = code;
    }

    public void setMsg(String msg) {
      this.msg = msg;
    }

    @Override
    public String toString() {
      return "{" + "\"code\": " + code + "," + "\"msg\": \"" + msg + "\"" + "}";
    }
  }
}
