/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.util.Md5Util
 * @date: 2018-06-11 11:29
 * @des: md5工具类
 */
public class Md5Util {
  private Md5Util() {
  }

  /**
   * md5
   *
   * @param str 要加密的字符串
   * @return md5值
   */
  public static String encrypt(String str) {
    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      BASE64Encoder base64en = new BASE64Encoder();
      return base64en.encode(md5.digest(str.getBytes("utf-8")));
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
      //ignore
      return "";
    }
  }
}
