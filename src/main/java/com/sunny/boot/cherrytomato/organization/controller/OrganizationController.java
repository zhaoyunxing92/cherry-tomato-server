/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.controller;

import com.sunny.boot.cherrytomato.common.context.AppUserContext;
import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.common.valid.InsertGroup;
import com.sunny.boot.cherrytomato.organization.controller.form.OrgForm;
import com.sunny.boot.cherrytomato.organization.model.Organization;
import com.sunny.boot.cherrytomato.organization.service.OrganizationService;
import com.sunny.boot.cherrytomato.user.controller.form.valid.LoginGroup;
import com.sunny.boot.cherrytomato.user.model.vo.AppUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.controller.OrganizationController
 * @date: 2018-06-18 12:28
 * @des: 组织模块
 */
@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    /**
     * 创建组织
     *
     * @param form 组织模块表单
     * @return 组织id
     */
    @PostMapping
    public Response addOrganization(@RequestBody @Validated({InsertGroup.class}) OrgForm form) {

        return new Response<Long>(Response.Result.ORG_INSERT_SUCCESS, organizationService.addOrganization(form), form.getName());
    }


}
