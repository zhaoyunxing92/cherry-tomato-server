/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.service.impl;

import com.sunny.boot.cherrytomato.common.context.AppUserContext;
import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.core.exception.AppServiceException;
import com.sunny.boot.cherrytomato.organization.model.Organization;
import com.sunny.boot.cherrytomato.organization.service.OrganizationService;
import com.sunny.boot.cherrytomato.project.controller.from.ProjectForm;
import com.sunny.boot.cherrytomato.project.mapper.OrgProjectMapper;
import com.sunny.boot.cherrytomato.project.model.OrgProject;
import com.sunny.boot.cherrytomato.project.service.OrganizationProjectMemberService;
import com.sunny.boot.cherrytomato.project.service.OrganizationProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.service.impl.OrganizationProjectServiceImpl
 * @date: 2018-06-26 15:44
 * @des: 项目服务模块
 */
@Service
public class OrganizationProjectServiceImpl implements OrganizationProjectService {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private OrganizationProjectMemberService orgProjectMemberService;
    @Autowired
    private OrgProjectMapper orgProjectMapper;

    /**
     * 创建项目
     *
     * @param form
     * @return 项目id
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Long addOrganizationProject(ProjectForm form) {
        Long orgId = form.getOrgId();
        Organization org = organizationService.getOrganization(orgId);
        //验证团队是否存在
        if (Objects.isNull(org)) {
            throw new AppServiceException(Response.Result.ORG_IS_NOT_EXIST_ERROR, orgId);
        }
        //项目个数是否超限
        int count = orgProjectMapper.selectProjectCount(orgId);
        if (count >= org.getProjectLimit()) {
            throw new AppServiceException(Response.Result.ORG_PROJECT_COUNT_OVER_ERROR, org.getName());
        }
        //创建项目
        OrgProject project = new OrgProject();
        project.setOrgId(orgId);
        project.setDescription(form.getDesc());
        project.setName(form.getName());
        orgProjectMapper.insertSelective(project);
        // 添加成员
        Long proId = project.getId();
        orgProjectMemberService.addOrgProjectMember(proId,AppUserContext.userId(), true);
        return proId;
    }
}
