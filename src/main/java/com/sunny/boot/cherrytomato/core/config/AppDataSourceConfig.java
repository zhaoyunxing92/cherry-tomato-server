package com.sunny.boot.cherrytomato.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.config.AppDataSourceConfig
 * @date: 2018-06-08 17:52
 * @des: mysql数据库配置
 */
//@Configuration
public class AppDataSourceConfig {

//  @Bean(destroyMethod = "close", initMethod = "init")
  @Bean
  @Primary   //优先使用
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource writeDataSource() {

       /* DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initialSize")));
        datasource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("minIdle")));
        datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty("maxWait")));
        datasource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("maxActive")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("minEvictableIdleTimeMillis")));*/
    return new DruidDataSource();
  }
}
