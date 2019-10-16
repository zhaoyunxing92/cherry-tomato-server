/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.service.impl;

import io.github.sunny.cherry.tomato.account.dao.CherryAccountDao;
import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.service.AccountService;
import io.github.sunny.cherry.tomato.core.result.Response;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 账户模块
 *
 * @author zhaoyunxing
 * @date: 2019-10-12 17:53
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private CherryAccountDao cherryAccountDao;

    @Override
    public Response<CherryAccountDto> register(CherryAccountDto dto) {
        return cherryAccountDao.register(dto);
    }
}
