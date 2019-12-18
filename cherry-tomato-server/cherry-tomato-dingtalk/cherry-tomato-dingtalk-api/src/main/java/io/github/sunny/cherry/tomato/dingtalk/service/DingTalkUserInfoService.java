/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.dto.DingTalkUserInfoDto;
import io.github.sunny.cherry.tomato.dingtalk.req.DingTalkUserInfoReq;

/**
 * 小程序用户服务
 *
 * @author zhaoyunxing
 * @date: 2019-12-18 12:56
 * @desc:
 */
public interface DingTalkUserInfoService {

    /**
     * 获取钉钉用户信息
     *
     * @param req 企业信息
     * @return DingTalkUserInfoDto
     */
    Response<DingTalkUserInfoDto> getDingTalkUserInfo(DingTalkUserInfoReq req);
}
