/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.dao.impl;

import io.github.sunny.cherry.tomato.account.dao.CherryAccountDao;
import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.mapper.CherryAccountMapper;
import io.github.sunny.cherry.tomato.account.model.CherryAccount;
import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 10:47
 */
@Service
public class CherryAccountDaoImpl implements CherryAccountDao {

    private final CherryAccountMapper cherryAccountMapper;

    public CherryAccountDaoImpl(CherryAccountMapper cherryAccountMapper) {this.cherryAccountMapper = cherryAccountMapper;}

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Response<CherryAccount> register(CherryAccountDto dto) {
        CherryAccount account = new CherryAccount();
        BeanUtils.copyProperties(dto, account);
        account.setCreator(0L);
        account.setModifier(0L);
        int rows = cherryAccountMapper.insertSelective(account);

        if (rows > 0) {
            return ResultUtil.success("创建成功", account);
        }
        return ResultUtil.error("创建账户失败");
    }
}
