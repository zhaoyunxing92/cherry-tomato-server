package com.sunny.boot.cherrytomato.core.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.sunny.boot.cherrytomato.core.interceptor.AppGlobalHandlerInterceptor;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunny
 * @class: com.sunny.workflow.users.common.vo.config.AppWebMvcConfigurerAdapter
 * @date: 2018-05-18 1:06
 * @des:
 */
public class AppWebMvcConfigurerAdapter implements WebMvcConfigurer {


  /**
   * 跨域配置
   *
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowCredentials(true)
        .allowedMethods("GET", "POST", "DELETE", "PUT")
        .maxAge(3600);

  }

  /**
   * 拦截器配置
   *
   * @param registry
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
    CacheControl nocache = CacheControl.noCache();
    webContentInterceptor.addCacheMapping(nocache, "/**");
    registry.addInterceptor(webContentInterceptor);
    //添加拦截器
    registry.addInterceptor(new AppGlobalHandlerInterceptor()).addPathPatterns("/**");
    WebMvcConfigurer.super.addInterceptors(registry);

  }

  /**
   * url 参数配置
   *
   * @param configurer
   */
  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    //url支持 sunny.com 参数
    configurer.setUseSuffixPatternMatch(false);
  }

  /**
   * 添加gson解析器（过滤返回的数据排除为null的）
   * <a href="http://blog.gelu.me/2017/spring-boot-uses-gson-to-replace-jackson/">参考地址</a>
   *
   * @param converters
   */
  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter); // 删除MappingJackson2HttpMessageConverter

    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    SerializerFeature[] serializerFeatures = new SerializerFeature[]{
        //  输出key是包含双引号
//        SerializerFeature.QuoteFieldNames,
        //  是否输出为null的字段,若为null 则显示该字段
        //   SerializerFeature.WriteMapNullValue,
        SerializerFeature.WriteNullNumberAsZero,
        SerializerFeature.WriteNullListAsEmpty,
        SerializerFeature.WriteNullStringAsEmpty,
        SerializerFeature.WriteNullBooleanAsFalse,
        SerializerFeature.WriteDateUseDateFormat,
        SerializerFeature.DisableCircularReferenceDetect,
    };

    fastJsonConfig.setSerializerFeatures(serializerFeatures);
    fastJsonConfig.setCharset(Charset.forName("UTF-8"));
    fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
    fastConverter.setFastJsonConfig(fastJsonConfig);
    System.out.println("fastJsonConfig.getDateFormat()>>>" + fastJsonConfig.getDateFormat());
    HttpMessageConverter<?> converter = fastConverter;
    List<MediaType> mediaTypes = new ArrayList<>();
    mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定json格式且编码为UTF-8
    fastConverter.setSupportedMediaTypes(mediaTypes);

    converters.add(converter);

  }
//  /**
//   * 跨域配置
//   *
//   * @param registry
//   */
//  @Override
//  public void addCorsMappings(CorsRegistry registry) {
//    registry.addMapping("/**")
//        .allowedOrigins("*")
//        .allowCredentials(true)
//        .allowedMethods("GET", "POST", "DELETE", "PUT")
//        .maxAge(3600);
//
//  }
//
//  /**
//   * 拦截器配置
//   *
//   * @param registry
//   */
//  @Override
//  public void addInterceptors(InterceptorRegistry registry) {
//    WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
//    CacheControl nocache = CacheControl.noCache();
//    webContentInterceptor.addCacheMapping(nocache, "/**");
//    registry.addInterceptor(webContentInterceptor);
//    //添加拦截器
//    registry.addInterceptor(new AppGlobalHandlerInterceptor()).addPathPatterns("/**");
//    WebMvcConfigurer.super.addInterceptors(registry);
//
//  }
//
//  @Bean
//  public HttpMessageConverters fastJsonHttpMessageConverters() {
//    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//    FastJsonConfig fastJsonConfig = new FastJsonConfig();
//    SerializerFeature[] serializerFeatures = new SerializerFeature[]{
//        //  输出key是包含双引号
////        SerializerFeature.QuoteFieldNames,
//        //  是否输出为null的字段,若为null 则显示该字段
//     //   SerializerFeature.WriteMapNullValue,
//        SerializerFeature.WriteNullNumberAsZero,
//        SerializerFeature.WriteNullListAsEmpty,
//        SerializerFeature.WriteNullStringAsEmpty,
//        SerializerFeature.WriteNullBooleanAsFalse,
//        SerializerFeature.WriteDateUseDateFormat,
//        SerializerFeature.DisableCircularReferenceDetect,
//    };
//
//    fastJsonConfig.setSerializerFeatures(serializerFeatures);
//    fastJsonConfig.setCharset(Charset.forName("UTF-8"));
//    fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//    fastConverter.setFastJsonConfig(fastJsonConfig);
//
//    HttpMessageConverter<?> converter = fastConverter;
//    List<MediaType> mediaTypes = new ArrayList<>();
//    mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定json格式且编码为UTF-8
//    fastConverter.setSupportedMediaTypes(mediaTypes);
//
//    return new HttpMessageConverters(converter);
//  }
}
