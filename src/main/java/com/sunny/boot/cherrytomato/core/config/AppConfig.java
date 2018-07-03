package com.sunny.boot.cherrytomato.core.config;

import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.config.AppConfig
 * @date: 2018-06-08 17:53
 * @des:
 */
@Import({AppDataSourceConfig.class, AppWebMvcConfigurerAdapter.class, AppMyBatisConfig.class, AppSpringContextAware.class, AppSpringBeanAware.class, AppRedisConfig.class})
public class AppConfig {
}
