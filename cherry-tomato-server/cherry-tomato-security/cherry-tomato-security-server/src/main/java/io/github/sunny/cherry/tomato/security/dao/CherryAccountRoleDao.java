/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.dao;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.security.model.CherryAccountRole;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 13:30
 */
public interface CherryAccountRoleDao {
    /**
     * 分配角色
     *
     * @param accountId 账户id
     * @param roleId 角色id
     * @return {@link CherryAccountRole}
     */
    Response assignRoles(Long accountId, Long roleId);
}
