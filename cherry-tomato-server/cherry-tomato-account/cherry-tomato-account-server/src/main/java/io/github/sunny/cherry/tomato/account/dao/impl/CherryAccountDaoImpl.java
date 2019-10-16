/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.dao.impl;

import io.github.sunny.cherry.tomato.account.dao.CherryAccountDao;
import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.mapper.CherryAccountMapper;
import io.github.sunny.cherry.tomato.account.model.CherryAccount;
import io.github.sunny.cherry.tomato.core.result.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 10:47
 */
@Service
public class CherryAccountDaoImpl implements CherryAccountDao {

    private final CherryAccountMapper cherryAccountMapper;

    public CherryAccountDaoImpl(CherryAccountMapper cherryAccountMapper) {this.cherryAccountMapper = cherryAccountMapper;}

    @Override
    public Response<CherryAccountDto> register(CherryAccountDto dto) {
        CherryAccount account = new CherryAccount();
        BeanUtils.copyProperties(dto, account);
        cherryAccountMapper.insertSelective(account);
        return null;
    }
}
