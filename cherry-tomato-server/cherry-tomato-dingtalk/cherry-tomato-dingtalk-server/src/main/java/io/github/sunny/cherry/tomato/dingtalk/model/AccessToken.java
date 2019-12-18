/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.model;

import lombok.Data;

import java.util.Date;

/**
 * @author zhaoyunxing
 * @date: 2019-12-17 18:58
 * @desc:
 */
@Data
public class AccessToken {

    /**
     * 企业id
     */
    private String corpId;
    /**
     * appKey
     */
    private String appKey;
    /**
     * token
     */
    private String accessToken;
    /**
     * 过期时间
     */
    private Date expiresIn;

}
