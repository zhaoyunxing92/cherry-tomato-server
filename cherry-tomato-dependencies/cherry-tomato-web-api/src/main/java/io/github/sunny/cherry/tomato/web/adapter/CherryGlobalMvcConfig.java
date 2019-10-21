/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.web.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zhaoyunxing
 * @date: 2019-10-17 17:07
 */
@Configuration
public class CherryGlobalMvcConfig extends WebMvcConfigurationSupport {
//    @Bean
//    public LocaleResolver localeResolver() {
//        return new CherryLocaleResolver();
//    }

    /**
     * 配置自己的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
    }

}
