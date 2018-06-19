/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.core.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.config.AppSpringContextAware
 * @date: 2018-06-12 14:47
 * @des: springContext
 * @see
 */
public class AppSpringContextAware implements ApplicationContextAware {
    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 获取当前环境
     *
     * @return
     */
    public static String[] getActiveProfile() {
        return context.getEnvironment().getActiveProfiles();
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
        return context.getBean(beanName);
    }

    /**
     * 根据类名称获取
     *
     * @param requiredType
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }
}
