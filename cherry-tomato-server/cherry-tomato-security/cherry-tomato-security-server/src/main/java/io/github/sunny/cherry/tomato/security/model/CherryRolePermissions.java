/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.model;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sunny
 * @date: 2019-10-16 13:13:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CherryRolePermissions extends BaseModel<Long> {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long permissionsId;
}