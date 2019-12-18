/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.model;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * 小程序信息
 *
 * @author zhaoyunxing
 * @date: 2019-12-18 02:53
 * @desc:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "micro_app")
public class MicroApp extends BaseModel<String> {

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
