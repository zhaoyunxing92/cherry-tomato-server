/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.controller.from;

import com.sunny.boot.cherrytomato.common.valid.InsertGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.controller.from.ProjectForm
 * @date: 2018-06-26 15:43
 * @des:
 */
public class ProjectForm {
    /**
     * 组织id
     */
    @NotNull(message = "字段【name】必填", groups = {InsertGroup.class})
    private Long orgId;
    /**
     * 项目名称（只能字母和汉字）
     */
    @NotNull(message = "字段【name】必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入项目名称", groups = {InsertGroup.class})
    @Length(min = 3, max = 15, message = "项目名称在{min}~{max}个字符之间", groups = {InsertGroup.class})
    @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z]+$", message = "项目名称只能字母和汉字", groups = {InsertGroup.class})
    private String name;
    /**
     * 项目描述
     */
    @NotNull(message = "字段【desc】必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入项目描述", groups = {InsertGroup.class})
    @Length(min = 3, max = 500, message = "项目简介在{min}~{max}个字符之间", groups = {InsertGroup.class})
    private String desc;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
