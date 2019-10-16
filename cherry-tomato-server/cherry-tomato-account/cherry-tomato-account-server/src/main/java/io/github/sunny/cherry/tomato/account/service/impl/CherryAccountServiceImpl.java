/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.service.impl;

import io.github.sunny.cherry.tomato.account.dao.CherryAccountDao;
import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.model.CherryAccount;
import io.github.sunny.cherry.tomato.account.service.CherryAccountService;
import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 账户模块
 *
 * @author zhaoyunxing
 * @date: 2019-10-12 17:53
 */
@Service
public class CherryAccountServiceImpl implements CherryAccountService {

    @Autowired
    private CherryAccountDao cherryAccountDao;

    /**
     * 注册账户
     *
     * @param dto {@link CherryAccountDto}
     * @return
     */
    @Override
    public Response<CherryAccountDto> register(CherryAccountDto dto) {
        CherryAccountDto cherryAccountDto = new CherryAccountDto();
        // 添加账户
        CherryAccount account = cherryAccountDao.register(dto);
        //添加权限
        BeanUtils.copyProperties(account,cherryAccountDto);
        return ResultUtil.success(200, "",cherryAccountDto);
    }
}
