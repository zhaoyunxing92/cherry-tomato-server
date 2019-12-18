/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author zhaoyunxing
 * @date: 2019-12-17 15:54
 * @desc:
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cherry.dingtalk")
public class DingTalkProperties {
    /**
     * 代理app
     */
    private Long agentId;

    /**
     * 企业id
     */
    private String corpId;
    /**
     * appKey
     */
    private String appKey;

    /**
     * app secret
     */
    private String appSecret;

    /**
     * 事件回调地址
     */
    private String callbackUrl;
    /**
     * 加解密需要用到的token，ISV(服务提供商)推荐使用注册套件时填写的token，普通企业可以随机填写
     */
    private String token;
    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成，ISV(服务提供商)推荐使用注册套件时填写的EncodingAESKey
     */
    private String aesKey;
    /**
     * 处理的事件
     */
    private List<String> callBackTag;
}
