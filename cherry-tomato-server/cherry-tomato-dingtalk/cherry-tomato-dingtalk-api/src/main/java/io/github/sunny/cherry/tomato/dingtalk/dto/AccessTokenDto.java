/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.dto;

import io.github.sunny.cherry.tomato.core.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 00:39
 * @desc:
 */
@Getter
@Setter
public class AccessTokenDto extends BaseDto {
    /**
     * 错误code
     */
    private Integer errCode;
    /**
     * token
     */
    private String accessToken;
    /**
     * 错误信息
     */
    private String errMsg;
    /**
     * 过期时间
     */
    private Integer expiresIn;
}
