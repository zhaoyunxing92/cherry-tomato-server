/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.mapper;

import io.github.sunny.cherry.tomato.core.common.mapper.BaseMapper;
import io.github.sunny.cherry.tomato.security.model.CherryRolePermissions;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author sunny
 * @date: 2019-10-16 13:12:42
 */
@Repository
public interface CherryRolePermissionsMapper extends BaseMapper<CherryRolePermissions, Long> {
    /**
     * 获取该账号的权限
     *
     * @param accountId 账号id
     * @return 权限
     */
    Set<String> selectPermissionsByAccountId(Long accountId);
}