/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.controller.form;

import com.sunny.boot.cherrytomato.common.valid.DelGroup;
import com.sunny.boot.cherrytomato.common.valid.InsertGroup;

import javax.validation.constraints.NotNull;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.organization.controller.form.OrgMemberForm
 * @date: 2018-06-25 17:43
 * @des: 团队成员表单
 */
public class OrgMemberForm {
    /**
     * 团队id
     */
    @NotNull(message = "字段【orgId】必填", groups = {InsertGroup.class, DelGroup.class})
    private Long orgId;
    /**
     * 用户id
     */
    @NotNull(message = "字段【userId】必填", groups = {InsertGroup.class, DelGroup.class})
    private Long userId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
