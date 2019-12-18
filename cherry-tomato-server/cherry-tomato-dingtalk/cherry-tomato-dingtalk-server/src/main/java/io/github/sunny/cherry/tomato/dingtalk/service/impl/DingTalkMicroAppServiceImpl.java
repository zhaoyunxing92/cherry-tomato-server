/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service.impl;

import io.github.sunny.cherry.tomato.dingtalk.config.DingTalkProperties;
import io.github.sunny.cherry.tomato.dingtalk.dao.MicroAppDao;
import io.github.sunny.cherry.tomato.dingtalk.model.MicroApp;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkMicroAppService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 12:39
 * @desc:
 */
@Service
public class DingTalkMicroAppServiceImpl implements DingTalkMicroAppService {

    private final DingTalkProperties dingTalkProperties;
    private final MicroAppDao microappDao;

    public DingTalkMicroAppServiceImpl(DingTalkProperties dingTalkProperties, MicroAppDao microappDao) {
        this.dingTalkProperties = dingTalkProperties;
        this.microappDao = microappDao;
    }

    /**
     * 注册钉钉小程序
     *
     * @param microApp 小程序信息
     */
    @Override
    public void registerMicroAppService(MicroApp microApp) {
        microApp.setCreatorTime(new Date());
        microappDao.insert(microApp);
    }

    /**
     * 注册小程序
     *
     * @return token
     */
    @Override
    public String registerMicroAppService() {
        /**
         * 保存小程序信息
         */
        MicroApp microApp = new MicroApp();
        BeanUtils.copyProperties(dingTalkProperties, microApp);
        registerMicroAppService(microApp);
        // 获取token
        return null;
    }

    /**
     * 获取小程序信息
     *
     * @param corpId 企业id
     * @param appKey appkey
     * @return MicroApp
     */
    @Override
    public MicroApp selectMicroApp(String corpId, String appKey) {
        MicroApp microApp = microappDao.findByCorpIdAndAppKey(corpId, appKey);
        if (Objects.isNull(microApp)) {
            microApp = new MicroApp();
            BeanUtils.copyProperties(dingTalkProperties, microApp);
            registerMicroAppService(microApp);
        }
        return microApp;
    }
}
