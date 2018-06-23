/**
 * Copyright(C) 2018 Hangzhou ${user} Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.service.impl;

import com.sunny.boot.cherrytomato.common.context.AppUserContext;
import com.sunny.boot.cherrytomato.organization.controller.form.OrgForm;
import com.sunny.boot.cherrytomato.organization.mapper.OrganizationMapper;
import com.sunny.boot.cherrytomato.organization.model.Organization;
import com.sunny.boot.cherrytomato.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.service.impl.OrganizationServiceImpl
 * @date: 2018-06-18 23:23
 * @des:
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Long addOrganization(OrgForm form) {
        Organization org = new Organization();
        org.setName(form.getName());
        org.setDescription(form.getDesc());
        org.setCreator(new AppUserContext().getUserId());
        org.setModifier(new AppUserContext().getUserId());
        return organizationMapper.insertSelective(org);
    }
}
