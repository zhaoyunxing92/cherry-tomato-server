/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.service.impl;

import com.sunny.boot.cherrytomato.organization.mapper.OrganizationMemberMapper;
import com.sunny.boot.cherrytomato.organization.model.OrganizationMember;
import com.sunny.boot.cherrytomato.organization.service.OrganizationMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.service.impl.OrganizationMemberServiceImpl
 * @date: 2018-06-25 17:16
 * @des:
 */
@Service
public class OrganizationMemberServiceImpl implements OrganizationMemberService {
    @Autowired
    private OrganizationMemberMapper organizationMemberMapper;

    @Override
    public void addOrganizationMember(Long orgId, Long userId) {
        addOrganizationMember(orgId, userId, false);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addOrganizationMember(Long orgId, Long userId, Boolean auto) {
        // 是否检验用户超额
        if (!auto) {

        }
        OrganizationMember member = new OrganizationMember();
        member.setOrgId(orgId);
        member.setUserId(userId);
        member.setIsSuperAdmin(auto);
        organizationMemberMapper.insertSelective(member);
    }
}
