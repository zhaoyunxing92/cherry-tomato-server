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
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] bytes = md.digest(str.getBytes("utf-8"));
      return toHex(bytes);
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
      //ignore
      return "";
    }
  }

  /**
   * 转换字节数组为16进制字串
   *
   * @param bytes
   * @return
   */
  private static String toHex(byte[] bytes) {

    final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    StringBuilder ret = new StringBuilder(bytes.length * 2);
    for (int i = 0; i < bytes.length; i++) {
      ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
      ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
    }
    return ret.toString();
  }
}
