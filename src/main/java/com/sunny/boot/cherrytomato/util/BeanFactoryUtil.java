/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.util.BeanFactoryUtil
 * @date: 2018-06-12 13:42
 * @des: 获取bean的工具类
 */
public class BeanFactoryUtil implements BeanFactoryAware {

  private static BeanFactory beanFactory;

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }


}
