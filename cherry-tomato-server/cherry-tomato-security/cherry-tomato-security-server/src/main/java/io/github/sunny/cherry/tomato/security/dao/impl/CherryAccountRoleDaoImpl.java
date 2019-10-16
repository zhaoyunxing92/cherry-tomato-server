/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.dao.impl;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
import io.github.sunny.cherry.tomato.security.dao.CherryAccountRoleDao;
import io.github.sunny.cherry.tomato.security.mapper.CherryAccountRoleMapper;
import io.github.sunny.cherry.tomato.security.model.CherryAccountRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 13:39
 */
@Service
public class CherryAccountRoleDaoImpl implements CherryAccountRoleDao {

    private final CherryAccountRoleMapper cherryAccountRoleMapper;

    public CherryAccountRoleDaoImpl(CherryAccountRoleMapper cherryAccountRoleMapper) {this.cherryAccountRoleMapper = cherryAccountRoleMapper;}

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Response assignRoles(Long accountId, Long roleId) {
        CherryAccountRole role = new CherryAccountRole();
        role.setAccountId(accountId);
        role.setRoleId(roleId);

        int rows = cherryAccountRoleMapper.insertSelective(role);
        if (rows > 0) {
            return ResultUtil.success("授权成功");
        }
        return ResultUtil.error("授权失败");
    }

}
