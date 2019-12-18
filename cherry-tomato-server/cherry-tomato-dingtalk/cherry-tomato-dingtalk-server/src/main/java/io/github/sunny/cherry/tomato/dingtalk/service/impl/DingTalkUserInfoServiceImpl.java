/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service.impl;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.dto.DingTalkUserInfoDto;
import io.github.sunny.cherry.tomato.dingtalk.req.DingTalkUserInfoReq;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkUserInfoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 13:16
 * @desc:
 */
@Service(interfaceClass = DingTalkUserInfoService.class)
public class DingTalkUserInfoServiceImpl implements DingTalkUserInfoService {

    /**
     * 获取钉钉用户信息
     *
     * @param req 企业信息
     * @return DingTalkUserInfoDto
     */
    @Override
    public Response<DingTalkUserInfoDto> getDingTalkUserInfo(DingTalkUserInfoReq req) {
        return null;
    }
}
