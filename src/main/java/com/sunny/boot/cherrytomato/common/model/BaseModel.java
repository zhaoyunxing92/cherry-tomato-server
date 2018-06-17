package com.sunny.boot.cherrytomato.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunny
 * @class: com.sunny.workflow.user.common.model.BaseModel
 * @date: 2018-05-18 17:00
 * @des: 父模型
 */
public class BaseModel<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 720013901235423189L;
    private ID id;

    /**
     * 用户状态(1=正常，8=冻结)
     */
    private Byte status;

    /**
     * 版本
     */
    private Integer versions;

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

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getVersions() {
        return versions;
    }

    public void setVersions(Integer versions) {
        this.versions = versions;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
