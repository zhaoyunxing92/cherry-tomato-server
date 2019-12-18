/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.req.DingTalkUserInfoReq;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkTokenService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 00:55
 * @desc:
 */
@RestController
@RequestMapping("/dingtalk/microapp")
public class DingTalkServiceController {

    @Reference
    private DingTalkTokenService dingTalkTokenService;

    /**
     * 获取用户信息
     * @param req
     * @return
     */
    @GetMapping("/user/info")
    public Response<String> getAccessToken(@RequestBody DingTalkUserInfoReq req) {
        return dingTalkTokenService.getUserInfo(req);
    }
}
