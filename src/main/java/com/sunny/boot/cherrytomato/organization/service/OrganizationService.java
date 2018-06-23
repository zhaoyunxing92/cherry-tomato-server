/**
 * Copyright(C) 2018 Hangzhou ${user} Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.service;

import com.sunny.boot.cherrytomato.organization.controller.form.OrgForm;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.service.OrganizationService
 * @date: 2018-06-18 23:18
 * @des: 组织模块服务
 */
public interface OrganizationService {
    /**
     * 添加组织
     *
     * @param form 组织表单
     * @return 返回组织id
     */
    Long addOrganization(OrgForm form);
}
