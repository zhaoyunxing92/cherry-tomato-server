/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.mapper;

import io.github.sunny.cherry.tomato.account.model.TxMsg;
import io.github.sunny.cherry.tomato.core.common.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author sunny
 * @date: 2019-10-23 17:32:19
 */
@Repository
public interface TxMsgMapper extends BaseMapper<TxMsg, String> {
}