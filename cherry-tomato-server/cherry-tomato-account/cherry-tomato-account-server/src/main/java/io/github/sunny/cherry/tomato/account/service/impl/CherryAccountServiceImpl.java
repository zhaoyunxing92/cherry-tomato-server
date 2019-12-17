/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.service.impl;

import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.service.CherryAccountService;
import io.github.sunny.cherry.tomato.core.result.Response;
import org.apache.dubbo.config.annotation.Service;

/**
 * 账户模块
 *
 * @author zhaoyunxing
 * @date: 2019-10-12 17:53
 */
@Service(interfaceClass = CherryAccountService.class)
public class CherryAccountServiceImpl implements CherryAccountService {

    /**
     * 注册账户
     *
     * @param dto {@link CherryAccountDto}
     * @return {@link CherryAccountDto}
     */
    @Override
    public Response<CherryAccountDto> register(CherryAccountDto dto) {
        return null;
    }
}
