/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 02:43
 * @desc:
 */
@Getter
@Setter
public class DingTalkUserInfoReq {
    /**
     * 免登授权码
     */
    private String code;
    /**
     * 企业id
     */
    private String corpId;
    /**
     * 小程序key
     */
    private String appKey;
}
