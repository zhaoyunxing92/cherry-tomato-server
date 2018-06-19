/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.util.SpringContextUtil
 * @date: 2018-06-12 13:10
 * @des: springContext工具类, 只获取当前启用的
 */
public class SpringContextUtil implements ApplicationContextAware {
    private SpringContextUtil() {
    }

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
}
