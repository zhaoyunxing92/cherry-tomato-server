/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.mapper;

import io.github.sunny.cherry.tomato.core.common.mapper.BaseMapper;
import io.github.sunny.cherry.tomato.security.model.CherryRole;
import org.springframework.stereotype.Repository;

/**
 * @author sunny
 * @date: 2019-10-16 12:37:34
 */
@Repository
public interface CherryRoleMapper extends BaseMapper<CherryRole, Long> {
}