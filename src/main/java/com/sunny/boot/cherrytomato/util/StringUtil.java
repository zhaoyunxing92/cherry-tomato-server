/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.util;

import java.util.regex.Pattern;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.util.StringUtil
 * @date: 2018-06-11 9:55
 * @des:
 */
public class StringUtil {

  /**
   * 正则表达式：验证邮箱
   */
  private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
  /**
   * 正则表达式：验证手机号
   */
  private static final String REGEX_MOBILE = "^1(3|4|5|6|7|8|9)\\d{9}$";

  /**
   * 判断是否邮箱
   *
   * @param email 邮箱
   * @return 是邮箱返回true
   */
  public static boolean isEmail(String email) {
    return Pattern.matches(REGEX_EMAIL, email);
  }

  /**
   * 判断是否手机号
   *
   * @param mobile 手机号
   * @return 是手机返回true
   */
  public static boolean isMobile(String mobile) {
    return Pattern.matches(REGEX_MOBILE, mobile);
  }

}
