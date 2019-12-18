/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.model;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author zhaoyunxing
 * @date: 2019-12-17 18:58
 * @desc:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "access_token")
public class AccessToken extends BaseModel<String> {

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
    private Long expiresIn;

}
