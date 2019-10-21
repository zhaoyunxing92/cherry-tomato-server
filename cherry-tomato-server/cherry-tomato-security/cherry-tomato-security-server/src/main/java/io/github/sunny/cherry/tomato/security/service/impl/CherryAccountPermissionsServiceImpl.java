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

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author zhaoyunxing
 * @date: 2019-10-18 11:10
 */
@Service
public class CherryAccountPermissionsServiceImpl implements CherryAccountPermissionsService {

    private final CherryRolePermissionsMapper cherryRolePermissionsMapper;


    public CherryAccountPermissionsServiceImpl(CherryRolePermissionsMapper cherryRolePermissionsMapper) {
        this.cherryRolePermissionsMapper = cherryRolePermissionsMapper;
    }

    /**
     * 分配角色
     * 如果创建的人没有分配角色需要处理下   permissions.removeIf(Objects::isNull);
     *
     * @param accountId 账户id
     * @return 角色
     */
    @Override
    public Response<List<String>> getPermissions(Long accountId) {
        // 注意去除null
        List<String> permissions = cherryRolePermissionsMapper.selectPermissionsByAccountId(accountId);
        permissions.removeIf(Objects::isNull);
        return ResultUtil.success("获取权限成功", permissions);
    }
}
