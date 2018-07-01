/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.model.vo;

import java.io.Serializable;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.organization.model.vo.OrganizationVo
 * @date: 2018-07-01 11:53
 * @des:
 */
public class OrganizationVo implements Serializable {
    private static final long serialVersionUID = -7228364830496529889L;
    /**
     * 团队id
     */
    private Long id;
    /**
     * 组织名称
     */
    private String name;

    /**
     * 组织头像
     */
    private String logo;
    /**
     * 是否超管
     */
    private Boolean admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
