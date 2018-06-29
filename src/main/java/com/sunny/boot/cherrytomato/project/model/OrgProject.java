/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

import java.util.Date;

public class OrgProject extends BaseModel<Long> {

    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目头像
     */
    private String logo;

    /**
     * 项目描述
     */
    private String description;

    /**
     * org_project
     */
    private static final long serialVersionUID = 1L;


    /**
     * 组织ID
     *
     * @return orgId 组织ID
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 组织ID
     *
     * @param orgId 组织ID
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 项目名称
     *
     * @return name 项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 项目名称
     *
     * @param name 项目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 项目头像
     *
     * @return logo 项目头像
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 项目头像
     *
     * @param logo 项目头像
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 项目描述
     *
     * @return description 项目描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 项目描述
     *
     * @param description 项目描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}