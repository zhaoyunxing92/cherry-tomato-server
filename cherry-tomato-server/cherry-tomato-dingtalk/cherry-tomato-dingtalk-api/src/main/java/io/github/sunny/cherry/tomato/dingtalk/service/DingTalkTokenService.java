/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.req.DingTalkUserInfoReq;


/**
 * 钉钉token服务
 *
 * @author zhaoyunxing
 * @date: 2019-12-18 00:23
 */
public interface DingTalkTokenService {

    /**
     * 获取token
     *
     * @param corpId 企业的id
     * @param appId  小程序的id
     * @return accessToken
     */
    Response<String> getAccessToken(String corpId, String appId);

    /**
     * 获取用户信息
     *
     * @param req
     * @return
     */
    Response<String> getUserInfo(DingTalkUserInfoReq req);
}
