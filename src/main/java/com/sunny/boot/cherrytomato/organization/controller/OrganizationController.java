/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.controller;

import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.common.valid.InsertGroup;
import com.sunny.boot.cherrytomato.common.valid.UpdateGroup;
import com.sunny.boot.cherrytomato.organization.controller.form.OrgForm;
import com.sunny.boot.cherrytomato.organization.model.vo.OrganizationVo;
import com.sunny.boot.cherrytomato.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 编辑团队信息
     *
     * @param form 组织模块表单
     * @return 团队
     */
    @PutMapping
    public Response modifyOrganization(@RequestBody @Validated({UpdateGroup.class}) OrgForm form) {
        organizationService.modifyOrganization(form);
        return new Response<Response.Result>(Response.Result.ORG_MODIFY_SUCCESS, form.getName());
    }

    /**
     * 获取当前登陆人的团队
     *
     * @param name 团队名称
     * @return
     */
    @GetMapping("/current")
    public Response<List<OrganizationVo>> addOrganization(String name) {

        return new Response<>(Response.Result.SUCCESS, organizationService.getCurrentOrganization(name));
    }
}
