/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.controller;

import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.common.valid.InsertGroup;
import com.sunny.boot.cherrytomato.organization.controller.form.OrgMemberForm;
import com.sunny.boot.cherrytomato.project.controller.from.ProjectMemberForm;
import com.sunny.boot.cherrytomato.project.service.OrganizationProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.controller.ProjectMemberController
 * @date: 2018-06-29 13:38
 * @des: 项目成员控制器
 */
@RestController
@RequestMapping("/org/project/member")
public class ProjectMemberController {
    @Autowired
    private OrganizationProjectMemberService organizationProjectMemberService;
    /**
     * 添加成员
     *
     * @param form 成员模块表单
     * @return 团队信息
     */
    @PostMapping
    public Response addProjectMember(@RequestBody @Validated({InsertGroup.class}) ProjectMemberForm form) {
        organizationProjectMemberService.addOrgProjectMember(form.getProId(),form.getUserId());
        return new Response<Response.Result>(Response.Result.ORG_PROJECT_INSERT_MEMBER_SUCCESS);
    }
}
