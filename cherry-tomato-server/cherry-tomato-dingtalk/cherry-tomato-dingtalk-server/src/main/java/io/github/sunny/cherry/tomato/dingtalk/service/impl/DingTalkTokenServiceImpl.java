/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service.impl;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.dao.MicroAppDao;
import io.github.sunny.cherry.tomato.dingtalk.model.MicroApp;
import io.github.sunny.cherry.tomato.dingtalk.req.DingTalkUserInfoReq;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkMicroAppService;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkTokenService;
import io.github.sunny.dingtalk.embedded.DingTalkProperties;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 00:54
 * @desc: token 服务
 */
@Service(interfaceClass = DingTalkTokenService.class)
public class DingTalkTokenServiceImpl implements DingTalkTokenService {

    private final DingTalkProperties dingTalkProperties;
    private final MicroAppDao dingTalkMicroappDao;
    private final DingTalkMicroAppService dingTalkMicroAppService;

    public DingTalkTokenServiceImpl(DingTalkProperties dingTalkProperties, MicroAppDao dingTalkMicroappDao, DingTalkMicroAppService dingTalkMicroAppService) {
        this.dingTalkProperties = dingTalkProperties;
        this.dingTalkMicroappDao = dingTalkMicroappDao;
        this.dingTalkMicroAppService = dingTalkMicroAppService;
    }

    /**
     * 获取token
     *
     * @param corpId 企业的id
     * @param appId  小程序的id
     * @return accessToken
     */
    @Override
    public Response<String> getAccessToken(String corpId, String appId) {
        Long agentId = dingTalkProperties.getAgentId();
        return null;
    }

    /**
     * 获取用户信息
     *
     * @param req
     * @return
     */
    @Override
    public Response<String> getUserInfo(DingTalkUserInfoReq req) {
        MicroApp microapp = dingTalkMicroappDao.findByCorpIdAndAppKey(req.getCorpId(), req.getAppKey());
        if (Objects.isNull(microapp)) {
            BeanUtils.copyProperties(dingTalkProperties, microapp);
//            dingTalkMicroappDao.insert(microapp);

            dingTalkMicroAppService.registerMicroAppService(microapp);
        }
        return null;
    }
}
