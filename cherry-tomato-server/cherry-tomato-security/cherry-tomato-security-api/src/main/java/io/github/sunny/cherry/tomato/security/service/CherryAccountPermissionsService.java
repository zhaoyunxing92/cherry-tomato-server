/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.service;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.security.dto.CherryAccountRoleDto;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

/**
 * 角色服务
 *
 * @author zhaoyunxing
 * @date: 2019-10-16 13:45
 */
public interface CherryAccountPermissionsService {

    /**
     * 分配角色
     *
     * @param accountId 账户id
     * @return 角色
     */
    Response<List<String>> getPermissions(Long accountId);
}
