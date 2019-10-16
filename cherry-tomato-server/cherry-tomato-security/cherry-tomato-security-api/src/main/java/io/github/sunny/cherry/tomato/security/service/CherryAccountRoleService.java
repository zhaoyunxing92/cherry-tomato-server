/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.service;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.security.dto.CherryAccountRoleDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    Response assignRoles(@Min(value = 1000, message = "请输入正确的账户id") Long accountId, @Min(value = 1000, message = "请输入正确的角色id") Long roleId);
}
