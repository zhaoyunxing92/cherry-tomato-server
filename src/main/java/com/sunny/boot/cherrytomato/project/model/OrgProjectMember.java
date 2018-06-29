/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class OrgProjectMember extends BaseModel<Long> {
    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 是否管理员(0=否,1=是)
     */
    private Boolean isManage;

    /**
     * org_project_member
     */
    private static final long serialVersionUID = 1L;

    /**
     * 项目id
     * @return projectId 项目id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 项目id
     * @param projectId 项目id
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 用户id
     * @return userId 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 是否管理员(0=否,1=是)
     * @return isManage 是否管理员(0=否,1=是)
     */
    public Boolean getIsManage() {
        return isManage;
    }

    /**
     * 是否管理员(0=否,1=是)
     * @param isManage 是否管理员(0=否,1=是)
     */
    public void setIsManage(Boolean isManage) {
        this.isManage = isManage;
    }

}