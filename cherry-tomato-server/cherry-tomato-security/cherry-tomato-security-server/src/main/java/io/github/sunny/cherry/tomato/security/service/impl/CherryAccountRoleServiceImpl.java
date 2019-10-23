/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.service.impl;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.security.dao.CherryAccountRoleDao;
import io.github.sunny.cherry.tomato.security.dto.CherryAccountRoleDto;
import io.github.sunny.cherry.tomato.security.service.CherryAccountRoleService;
import org.apache.dubbo.config.annotation.Service;

import javax.validation.constraints.Min;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 13:58
 */
@org.springframework.stereotype.Service
@Service
public class CherryAccountRoleServiceImpl implements CherryAccountRoleService {

    private final CherryAccountRoleDao cherryAccountRoleDao;
    private final TxMsgService txMsgService;


    public CherryAccountRoleServiceImpl(CherryAccountRoleDao cherryAccountRoleDao, TxMsgService txMsgService) {this.cherryAccountRoleDao = cherryAccountRoleDao;
        this.txMsgService = txMsgService;
    }

    /**
     * 分配角色
     *
     * @param accountId 账户id
     * @param roleId    角色
     * @return {@link CherryAccountRoleDto}
     */
    @Override
    public Response assignRoles(Long accountId, Long roleId) {
        return cherryAccountRoleDao.assignRoles(accountId, roleId);
    }

    /**
     * 通过消息分配角色
     *
     * @param accountId
     * @param roleId
     */
    @Override
    public void msgAssignRoles(@Min(value = 1000, message = "请输入正确的账户id") Long accountId, @Min(value = 1000, message = "请输入正确的角色id") Long roleId) {
        cherryAccountRoleDao.assignRoles(accountId, roleId);
    }

}
