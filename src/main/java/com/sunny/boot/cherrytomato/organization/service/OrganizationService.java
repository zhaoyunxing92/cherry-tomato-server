/**
 * Copyright(C) 2018 Hangzhou ${user} Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.service;

import com.sunny.boot.cherrytomato.organization.controller.form.OrgForm;
import com.sunny.boot.cherrytomato.organization.model.Organization;
import com.sunny.boot.cherrytomato.organization.model.vo.OrganizationVo;

import java.util.List;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.service.OrganizationService
 * @date: 2018-06-18 23:18
 * @des: 组织模块服务
 */
public interface OrganizationService {
    /**
     * 添加团队
     *
     * @param form 组织表单
     * @return 返回团队信息
     */
    Long addOrganization(OrgForm form);

    /**
     * 根据团队id获取团队信息
     *
     * @param orgId 团队id
     * @return 团队
     */
    Organization getOrganization(Long orgId);

    /**
     * 获取当前登陆人的团队
     *
     * @return 团队
     */
    List<OrganizationVo> getCurrentOrganization();

    /**
     * 编辑团队信息
     *
     * @param form
     */
    void modifyOrganization(OrgForm form);
}
