/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.controller;

import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.common.valid.InsertGroup;
import com.sunny.boot.cherrytomato.organization.controller.form.OrgForm;
import com.sunny.boot.cherrytomato.organization.controller.form.OrgMemberForm;
import com.sunny.boot.cherrytomato.organization.service.OrganizationMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.organization.controller.OrganizationMemberController
 * @date: 2018-06-25 17:38
 * @des: 团队成员控制器
 */
@RestController
@RequestMapping("/org/member")
public class OrganizationMemberController {
    @Autowired
    private OrganizationMemberService organizationMemberService;

    /**
     * 团结添加成员
     *
     * @param form 成员模块表单
     * @return 组织id
     */
    @PostMapping
    public Response addOrganizationMember(@RequestBody @Validated({InsertGroup.class}) OrgMemberForm form) {
        return organizationMemberService.addOrganizationMember(form.getOrgId(), form.getUserId());
     //  return new Response<Response.Result>(Response.Result.ORG_MEMBER_INSERT_SUCCESS);
    }
}
