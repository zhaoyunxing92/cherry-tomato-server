/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.core.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.util.StringUtils;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.config.AppSpringBeanAware
 * @date: 2018-06-12 14:53
 * @des: 获取bean
 */
public class AppSpringBeanAware implements BeanFactoryAware {
    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 根据bean名称获取bean
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {

        if (StringUtils.isEmpty(beanName)) {
            throw new NullPointerException("beanName is empty!");
        }
        return beanFactory.getBean(beanName);
    }

    /**
     * 根据类名称获取
     *
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> requiredType) {
        return beanFactory.getBean(requiredType);
    }
}
