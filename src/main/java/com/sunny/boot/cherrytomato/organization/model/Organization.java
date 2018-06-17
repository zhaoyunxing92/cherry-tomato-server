/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;
import java.util.Date;

public class Organization extends BaseModel<Long> {
    /**
     * 组织名称
     */
    private String name;

    /**
     * 组织头像
     */
    private String logo;

    /**
     * 组织描述
     */
    private String description;

    /**
     * 组织成员上限
     */
    private Integer memberLimit;

    /**
     * 组织成员上限
     */
    private Integer projectLimit;


    /**
     * organization
     */
    private static final long serialVersionUID = 1L;


    /**
     * 组织名称
     * @return name 组织名称
     */
    public String getName() {
        return name;
    }

    /**
     * 组织名称
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 组织头像
     * @return logo 组织头像
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 组织头像
     * @param logo 组织头像
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 组织描述
     * @return description 组织描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 组织描述
     * @param description 组织描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 组织成员上限
     * @return memberLimit 组织成员上限
     */
    public Integer getMemberLimit() {
        return memberLimit;
    }

    /**
     * 组织成员上限
     * @param memberLimit 组织成员上限
     */
    public void setMemberLimit(Integer memberLimit) {
        this.memberLimit = memberLimit;
    }

    /**
     * 组织成员上限
     * @return projectLimit 组织成员上限
     */
    public Integer getProjectLimit() {
        return projectLimit;
    }

    /**
     * 组织成员上限
     * @param projectLimit 组织成员上限
     */
    public void setProjectLimit(Integer projectLimit) {
        this.projectLimit = projectLimit;
    }

}