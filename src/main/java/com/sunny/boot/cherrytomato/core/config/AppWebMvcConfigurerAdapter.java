package com.sunny.boot.cherrytomato.core.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters() {
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
    HttpMessageConverter<?> converter = fastConverter;
    List<MediaType> mediaTypes = new ArrayList<>();
    mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定json格式且编码为UTF-8
    fastConverter.setSupportedMediaTypes(mediaTypes);

    return new HttpMessageConverters(converter);
  }
}
