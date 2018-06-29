/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.controller.from;

import com.sunny.boot.cherrytomato.common.valid.InsertGroup;

import javax.validation.constraints.NotNull;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.controller.from.ProjectMemberForm
 * @date: 2018-06-29 13:41
 * @des:
 */
public class ProjectMemberForm {
    /**
     * 项目id
     */
    @NotNull(message = "字段【proId】必填", groups = {InsertGroup.class})
    private Long proId;
    /**
     * 成员id
     */
    @NotNull(message = "字段【userId】必填", groups = {InsertGroup.class})
    private Long userId;

    public Long getProId() {
        return proId;
    }

    public ProjectMemberForm setProId(Long proId) {
        this.proId = proId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public ProjectMemberForm setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
