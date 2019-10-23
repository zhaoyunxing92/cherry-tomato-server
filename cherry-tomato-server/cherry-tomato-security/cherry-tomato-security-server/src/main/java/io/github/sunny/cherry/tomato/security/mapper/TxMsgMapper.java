/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.mapper;

import io.github.sunny.cherry.tomato.core.common.mapper.BaseMapper;
import io.github.sunny.cherry.tomato.security.model.TxMsg;
import org.springframework.stereotype.Repository;

/**
 * @author sunny
 * @date: 2019-10-23 14:05:44
 */
@Repository
public interface TxMsgMapper extends BaseMapper<TxMsg, String> {
}