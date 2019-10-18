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
import io.github.sunny.cherry.tomato.security.service.CherryAccountRoleService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
    @Reference
    private CherryAccountRoleService cherryAccountRoleService;

    /**
     * 注册账户
     *
     * @param dto {@link CherryAccountDto}
     * @return {@link Response}
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Response register(CherryAccountDto dto) {
        // 添加账户
        Response<CherryAccount> cherryAccountResponse = cherryAccountDao.register(dto);
        //添加权限
        Response cherryAccountRoleDtoResponse = cherryAccountRoleService.assignRoles(cherryAccountResponse.getData().getId(), 1001L);

        if (cherryAccountResponse.isSuccess() && cherryAccountRoleDtoResponse.isSuccess()) {
            return ResultUtil.success("注册账户成功");
        }
        return ResultUtil.error("注册账户失败");
    }

    /**
     * 登录
     *
     * @param dto {@link CherryAccountDto}
     * @return {@link Response} 信息
     */
    @Override
    public Response login(CherryAccountDto dto) {
        return null;
    }
}
