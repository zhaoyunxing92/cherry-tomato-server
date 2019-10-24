/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.mapper;

import io.github.sunny.cherry.tomato.account.model.CherryAccount;
import io.github.sunny.cherry.tomato.core.common.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author sunny
 * @date: 2019-10-16 10:20:20
 */
@Repository
public interface CherryAccountMapper extends BaseMapper<CherryAccount, Long> {
    /**
     * 根据用户名获取账号
     *
     * @param name 用户名
     * @return CherryAccount
     */
    CherryAccount selectAccountByUserName(String name);
}