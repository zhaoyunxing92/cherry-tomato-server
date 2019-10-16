/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.service;

import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.core.result.Response;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 17:52
 */
public interface CherryAccountService {
    /**
     * 注册账户
     *
     * @param dto {@link CherryAccountDto}
     * @return {@link CherryAccountDto} 信息
     */
    Response<CherryAccountDto> register(CherryAccountDto dto);
}
