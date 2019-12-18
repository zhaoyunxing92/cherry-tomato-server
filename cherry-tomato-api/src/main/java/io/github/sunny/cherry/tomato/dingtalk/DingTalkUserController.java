/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.dto.DingTalkUserInfoDto;
import io.github.sunny.cherry.tomato.dingtalk.req.DingTalkUserInfoReq;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkUserInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 12:56
 * @desc:
 */
@RestController
@RequestMapping("/dingtalk/microapp/user")
public class DingTalkUserController {

    @Reference
    private DingTalkUserInfoService dingTalkUserInfoService;

    /**
     * 获取用户信息
     *
     * @param req 用户信息
     * @return
     */
    @GetMapping("/info")
    public Response<DingTalkUserInfoDto> getAccessToken(@RequestBody DingTalkUserInfoReq req) {
        return dingTalkUserInfoService.getDingTalkUserInfo(req);
    }
}
