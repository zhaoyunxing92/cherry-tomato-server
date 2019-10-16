/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.mapper;

import io.github.sunny.cherry.tomato.core.common.mapper.BaseMapper;
import io.github.sunny.cherry.tomato.security.model.CherryPermissions;
import org.springframework.stereotype.Repository;

/**
 * @author sunny
 * @date: 2019-10-16 13:12:42
 */
@Repository
public interface CherryPermissionsMapper extends BaseMapper<CherryPermissions, Long> {
}