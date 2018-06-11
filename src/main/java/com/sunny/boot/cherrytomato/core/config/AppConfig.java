package com.sunny.boot.cherrytomato.core.config;

import org.springframework.context.annotation.Import;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.config.AppConfig
 * @date: 2018-06-08 17:53
 * @des:
 */
@Import({AppDataSourceConfig.class, AppWebMvcConfigurerAdapter.class, AppMyBatisConfig.class})
public class AppConfig {
}
