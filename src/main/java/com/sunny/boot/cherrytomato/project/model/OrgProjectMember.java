/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;
import java.util.Date;

public class OrgProjectMember implements BaseModel<Long> {
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
     * 用户状态(1=正常，8=冻结)
     */
    private Byte status;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 修改时间
     */
    private Date modifyDate;

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

    /**
     * 用户状态(1=正常，8=冻结)
     * @return status 用户状态(1=正常，8=冻结)
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 用户状态(1=正常，8=冻结)
     * @param status 用户状态(1=正常，8=冻结)
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 创建人
     * @return creator 创建人
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 创建人
     * @param creator 创建人
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 创建时间
     * @return createDate 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 修改人
     * @return modifier 修改人
     */
    public Long getModifier() {
        return modifier;
    }

    /**
     * 修改人
     * @param modifier 修改人
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    /**
     * 修改时间
     * @return modifyDate 修改时间
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 修改时间
     * @param modifyDate 修改时间
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}