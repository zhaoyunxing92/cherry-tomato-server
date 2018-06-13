/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.util;

import com.sunny.boot.cherrytomato.core.config.AppSpringContextAware;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.util.EnvUtil
 * @date: 2018-06-12 13:19
 * @des: 获取当前的启动环境，注意对应的是resource目录下的application-xxx.yml文件
 */
public class EnvUtil {
  /**
   * 当前启用的配置文件，
   * TODO:如果是数组只获取第一个
   */
  private static String activeProfile;

  static {
    activeProfile = AppSpringContextAware.getActiveProfile()[0];
  }

  private EnvUtil() {
  }

  /**
   * 是否开发环境
   *
   * @return
   */
  public static boolean isDev() {
    return StringUtil.equals("dev", activeProfile);
  }

  /**
   * 是否test环境
   *
   * @return
   */
  public static boolean isTest() {
    return StringUtil.equals("test", activeProfile);
  }

  /**
   * 是否生产环境
   *
   * @return
   */
  public static boolean isProd() {
    return StringUtil.equals("prod", activeProfile);
  }
}
