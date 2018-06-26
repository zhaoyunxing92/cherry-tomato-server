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
import com.sunny.boot.cherrytomato.user.model.AppUser;
import com.sunny.boot.cherrytomato.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.service.impl.OrganizationMemberServiceImpl
 * @date: 2018-06-25 17:16
 * @des: 团队成员模块
 */
@Service
public class OrganizationMemberServiceImpl implements OrganizationMemberService {
    @Autowired
    private OrganizationMemberMapper organizationMemberMapper;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private AppUserService appUserService;

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
            if (Objects.isNull(organization))
                return new Response<Response.Result>(Response.Result.ORG_IS_NOT_EXIST_ERROR, orgId);
            //验证用户id
            AppUser appUser = appUserService.getAppUser(userId);
            if (Objects.isNull(appUser))
                return new Response<Response.Result>(Response.Result.USER_IS_NOT_EXIST_ERROR, userId);
            //验证用户是否已经添加
            List<Long> members = organizationMemberMapper.selectOrganizationMemberId(orgId);
            if (members.contains(userId))
                return new Response<Response.Result>(Response.Result.ORG_MEMBER_INSERT_SUCCESS);
            // 是否检验用户超额
            Integer memberLimit = organization.getMemberLimit();
            if (members.size() >= memberLimit)
                return new Response<Response.Result>(Response.Result.ORG_PERSONNEL_TRANSFINITE_ERROR, organization.getName());
        }


        OrganizationMember member = new OrganizationMember();
        member.setOrgId(orgId);
        member.setUserId(userId);
        member.setIsSuperAdmin(auto);
        organizationMemberMapper.insertSelective(member);

        return new Response<Response.Result>(Response.Result.ORG_MEMBER_INSERT_SUCCESS);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Response delOrganizationMember(Long orgId, Long userId) {
        return null;
    }
}
