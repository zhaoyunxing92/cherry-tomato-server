/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.model.vo;

import com.sunny.boot.cherrytomato.project.model.OrgProject;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.model.vo.OrgProjectVo
 * @date: 2018-07-05 23:49
 * @des: 项目扩展类
 */
public class OrgProjectVo extends OrgProject {
    private static final long    serialVersionUID = -4271369488313412433L;
    /**
     * 是否管理员
     */
    private              Boolean manage;

    public Boolean getManage() {
        return manage;
    }

    public OrgProjectVo setManage(Boolean manage) {
        this.manage = manage;
        return this;
    }
}
