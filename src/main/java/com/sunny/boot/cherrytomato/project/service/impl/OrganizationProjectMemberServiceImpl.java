/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.service.impl;

import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.core.exception.AppServiceException;
import com.sunny.boot.cherrytomato.project.mapper.OrgProjectMemberMapper;
import com.sunny.boot.cherrytomato.project.model.OrgProject;
import com.sunny.boot.cherrytomato.project.model.OrgProjectMember;
import com.sunny.boot.cherrytomato.project.service.OrganizationProjectMemberService;
import com.sunny.boot.cherrytomato.project.service.OrganizationProjectService;
import com.sunny.boot.cherrytomato.user.model.AppUser;
import com.sunny.boot.cherrytomato.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.service.impl.OrgProjectMemberServiceImpl
 * @date: 2018-06-29 13:05
 * @des:
 */
@Service
public class OrganizationProjectMemberServiceImpl implements OrganizationProjectMemberService {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private OrganizationProjectService organizationProjectService;
    @Autowired
    private OrgProjectMemberMapper orgProjectMemberMapper;

    @Override
    public void addOrgProjectMember(Long proId, Long userId) {
        addOrgProjectMember(proId, userId, false);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addOrgProjectMember(Long proId, Long userId, Boolean auto) {
        if (!auto) {
            OrgProject project = organizationProjectService.getOrgProjectById(proId);
            //项目校验
            if (Objects.isNull(project))
                throw new AppServiceException(Response.Result.ORG_PROJECT_IS_NOT_EXIST_ERROR, proId);
            //验证用户id
            AppUser appUser = appUserService.getAppUser(userId);
            if (Objects.isNull(appUser))
                throw new AppServiceException(Response.Result.USER_IS_NOT_EXIST_ERROR, userId);
            //项目成员重复验证
            List<Long> members = orgProjectMemberMapper.selectProjectMemberId(proId);
            if (members.contains(userId))
                return;
                //throw new AppServiceException(Response.Result.ORG_MEMBER_INSERT_SUCCESS);
            Integer memberLimit = project.getMemberLimit();
            if (members.size() >= memberLimit)
                throw new AppServiceException(Response.Result.ORG_PROJECT_PERSONNEL_TRANSFINITE_ERROR, project.getName());
        }
        OrgProjectMember member = new OrgProjectMember();
        member.setProjectId(proId);
        member.setUserId(userId);
        member.setIsManage(auto);
        orgProjectMemberMapper.insertSelective(member);
    }
}
