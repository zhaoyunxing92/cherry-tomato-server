/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service;

/**
 * AccessToken 服务
 *
 * @author zhaoyunxing
 * @date: 2019-12-18 13:17
 */
public interface AccessTokenService {
    /**
     * 获取token
     *
     * @param corpId
     * @param appKey
     * @return
     */
    String getAccessToken(String corpId, String appKey);
}
