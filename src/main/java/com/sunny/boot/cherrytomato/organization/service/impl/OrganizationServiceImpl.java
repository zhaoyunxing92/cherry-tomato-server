/**
 * Copyright(C) 2018 Hangzhou ${user} Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.service.impl;

import com.sunny.boot.cherrytomato.common.context.AppUserContext;
import com.sunny.boot.cherrytomato.organization.controller.form.OrgForm;
import com.sunny.boot.cherrytomato.organization.mapper.OrganizationMapper;
import com.sunny.boot.cherrytomato.organization.model.Organization;
import com.sunny.boot.cherrytomato.organization.model.vo.OrganizationVo;
import com.sunny.boot.cherrytomato.organization.service.OrganizationMemberService;
import com.sunny.boot.cherrytomato.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.service.impl.OrganizationServiceImpl
 * @date: 2018-06-18 23:23
 * @des: 团队模块服务实现类
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private OrganizationMemberService organizationMemberService;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Long addOrganization(OrgForm form) {
        Organization org = new Organization();
        org.setName(form.getName());
        org.setDescription(form.getDesc());
        // 创建团队
        organizationMapper.insertSelective(org);
        //添加成员
        Long orgId = org.getId();
        organizationMemberService.addOrganizationMember(orgId, AppUserContext.userId(), true);
        return orgId;
    }

    @Override
    public Organization getOrganization(Long orgId) {
        return organizationMapper.selectByPrimaryKey(orgId);
    }

    /**
     * 获取当前登陆人的团队
     *
     * @param name 团队名称
     * @return 团队
     */
    @Override
    public List<OrganizationVo> getCurrentOrganization(String name) {
        return organizationMapper.selectOrganizationByUserId(AppUserContext.userId(), name);
    }

    /**
     * 编辑团队信息
     *
     * @param form
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void modifyOrganization(OrgForm form) {
        Organization org = new Organization();
        org.setId(form.getId());
        org.setName(form.getName());
        org.setDescription(form.getDesc());

        organizationMapper.updateByPrimaryKeySelective(org);
    }
}
