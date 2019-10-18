/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.service.impl;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
import io.github.sunny.cherry.tomato.security.mapper.CherryRolePermissionsMapper;
import io.github.sunny.cherry.tomato.security.service.CherryAccountPermissionsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author zhaoyunxing
 * @date: 2019-10-18 11:10
 */
@Service
public class CherryAccountPermissionsServiceImpl implements CherryAccountPermissionsService {

    private final CherryRolePermissionsMapper cherryRolePermissionsMapper;

    @Autowired
    public CherryAccountPermissionsServiceImpl(CherryRolePermissionsMapper cherryRolePermissionsMapper) {
        this.cherryRolePermissionsMapper = cherryRolePermissionsMapper;
    }

    /**
     * 分配角色
     *
     * @param accountId 账户id
     * @return 角色
     */
    @Override
    public Response<Set<String>> getPermissions(Long accountId) {
        Set<String> permissions = cherryRolePermissionsMapper.selectPermissionsByAccountId(accountId);
        return ResultUtil.success("获取权限成功", permissions);
    }
}
