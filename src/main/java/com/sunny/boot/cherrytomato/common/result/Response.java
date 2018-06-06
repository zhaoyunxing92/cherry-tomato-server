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
}
