/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.dao;

import io.github.sunny.cherry.tomato.dingtalk.model.MicroApp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 02:56
 * @desc:
 */
@Repository
public interface MicroAppDao extends MongoRepository<MicroApp, String> {
    /**
     * 获取小程序信息
     *
     * @param corpId
     * @param appKey
     * @return DingTalkMicroApp
     */
    MicroApp findByCorpIdAndAppKey(String corpId, String appKey);
}
