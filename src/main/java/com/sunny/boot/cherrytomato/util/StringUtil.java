/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.util;

import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.util.StringUtil
 * @date: 2018-06-11 9:55
 * @des:
 */
public class StringUtil {
  private StringUtil() {
  }

  /**
   * 正则表达式：验证邮箱
   */
  private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
  /**
   * 正则表达式：验证手机号
   */
  private static final String REGEX_MOBILE = "^1([3456789])\\d{9}$";

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

  /**
   * 比较两个值是否相同
   *
   * @param str1
   * @param str2
   * @return
   */
  public static boolean equals(String str1, String str2) {
    if (null == str1) {
      str1 = "";
    }
    if (null == str2) {
      str2 = "";
    }
//    if (null == str1 || null == str2) {
//      return false;
//    }
    return str1.equals(str2);
  }

  /**
   * 验证异常信息转化string
   *
   * @param errors
   * @return
   */
  public static String errorsToString(List<ObjectError> errors) {
    StringBuilder errorsStr = new StringBuilder();
    if (null == errors || errors.isEmpty()) {
      return errorsStr.toString();
    }
    for (ObjectError error : errors) {
      errorsStr.append(error.getDefaultMessage()).append(",");
    }
    return errorsStr.substring(0, errorsStr.lastIndexOf(","));
  }
}
