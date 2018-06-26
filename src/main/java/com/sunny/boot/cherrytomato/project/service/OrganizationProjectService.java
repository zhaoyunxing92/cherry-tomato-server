/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.service;

import com.sunny.boot.cherrytomato.project.controller.from.ProjectForm;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.service.OrganizationProjectService
 * @date: 2018-06-26 15:41
 * @des: 项目服务模块
 */
public interface OrganizationProjectService {
    /**
     * 创建项目
     *
     * @param form 项目模块表单
     * @return 项目id
     */
    Long addOrganizationProject(ProjectForm form);

}
