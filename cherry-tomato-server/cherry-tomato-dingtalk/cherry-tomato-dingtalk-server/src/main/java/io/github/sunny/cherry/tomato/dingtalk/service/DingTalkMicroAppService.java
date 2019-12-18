/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service;

import io.github.sunny.cherry.tomato.dingtalk.model.MicroApp;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 12:37
 * @desc:
 */
public interface DingTalkMicroAppService {

    /**
     * 注册钉钉小程序
     *
     * @param microApp 小程序信息
     */
    void registerMicroAppService(MicroApp microApp);

    /**
     * 注册小程序
     *
     * @return token
     */
    String registerMicroAppService();

    /**
     * 获取小程序信息
     *
     * @param corpId
     * @param appKey
     * @return MicroApp
     */
    MicroApp selectMicroApp(String corpId, String appKey);
}
