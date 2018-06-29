/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.controller;

import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.common.valid.InsertGroup;
import com.sunny.boot.cherrytomato.project.controller.from.ProjectForm;
import com.sunny.boot.cherrytomato.project.service.OrganizationProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.controller.ProjectController
 * @date: 2018-06-26 15:37
 * @des: 项目控制器
 */
@RestController
@RequestMapping("/org/project")
public class ProjectController {
    @Autowired
    private OrganizationProjectService organizationProjectService;

    /**
     * 创建项目
     *
     * @param form 项目模块表单
     * @return 项目id
     */
    @PostMapping
    public Response addOrganization(@RequestBody @Validated({InsertGroup.class}) ProjectForm form) {
        
        return new Response<Long>(Response.Result.ORG_PROJECT_INSERT_SUCCESS, organizationProjectService.addOrganizationProject(form), form.getName());
    }
}
