/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.dao;

import io.github.sunny.cherry.tomato.dingtalk.model.AccessToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 12:49
 * @desc:
 */
@Repository
public interface MicroAppTokenDao extends MongoRepository<AccessToken, String> {
    /**
     * 获取token
     *
     * @param corpId 企业id
     * @param appKey appid
     * @return AccessToken
     */
    AccessToken findByCorpIdAndAppKey(String corpId, String appKey);
}
