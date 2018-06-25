/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.service.impl;

import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.organization.mapper.OrganizationMemberMapper;
import com.sunny.boot.cherrytomato.organization.model.Organization;
import com.sunny.boot.cherrytomato.organization.model.OrganizationMember;
import com.sunny.boot.cherrytomato.organization.service.OrganizationMemberService;
import com.sunny.boot.cherrytomato.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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
    @Autowired
    private OrganizationService organizationService;

    @Override
    public Response addOrganizationMember(Long orgId, Long userId) {
        return addOrganizationMember(orgId, userId, false);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Response addOrganizationMember(Long orgId, Long userId, Boolean auto) {

        if (!auto) {
            //验证orgId
            Organization organization = organizationService.getOrganization(orgId);
            if (Objects.isNull(organization)) {
                return new Response<Response.Result>(Response.Result.ORG_IS_NOT_EXIST_ERROR,orgId);
            }
            //验证用户id


            //验证用户是否已经添加

            // 是否检验用户超额
        }


        OrganizationMember member = new OrganizationMember();
        member.setOrgId(orgId);
        member.setUserId(userId);
        member.setIsSuperAdmin(auto);
        organizationMemberMapper.insertSelective(member);

        return new Response<Response.Result>(Response.Result.ORG_MEMBER_INSERT_SUCCESS);
    }
}
