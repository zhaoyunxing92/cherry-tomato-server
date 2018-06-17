/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;
import java.util.Date;

public class OrganizationMember extends BaseModel<Long> {
    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 用户是否超级管理员(只有创建的人是管理员，0=否，1=是。默认否)
     */
    private Boolean isSuperAdmin;


    /**
     * organization_member
     */
    private static final long serialVersionUID = 1L;

    /**
     * 组织ID
     * @return orgId 组织ID
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 组织ID
     * @param orgId 组织ID
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 用户ID
     * @return userId 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户备注
     * @return remark 用户备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 用户备注
     * @param remark 用户备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 用户是否超级管理员(只有创建的人是管理员，0=否，1=是。默认否)
     * @return isSuperAdmin 用户是否超级管理员(只有创建的人是管理员，0=否，1=是。默认否)
     */
    public Boolean getIsSuperAdmin() {
        return isSuperAdmin;
    }

    /**
     * 用户是否超级管理员(只有创建的人是管理员，0=否，1=是。默认否)
     * @param isSuperAdmin 用户是否超级管理员(只有创建的人是管理员，0=否，1=是。默认否)
     */
    public void setIsSuperAdmin(Boolean isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }


}