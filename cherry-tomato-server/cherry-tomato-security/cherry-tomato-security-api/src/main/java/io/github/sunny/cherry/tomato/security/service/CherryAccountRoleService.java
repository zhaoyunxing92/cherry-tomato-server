/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.service;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.security.dto.CherryAccountRoleDto;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 13:45
 */
public interface CherryAccountRoleService {
    /**
     * 分配角色
     *
     * @param accountId 账户id
     * @param roleId    角色
     * @return {@link CherryAccountRoleDto}
     */
    Response assignRoles(Long accountId, Long roleId);
}
