/**
 * Copyright(C) 2018 Hangzhou ${user} Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.controller.form;

import com.sunny.boot.cherrytomato.common.valid.InsertGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.controller.form.OrgForm
 * @date: 2018-06-18 17:26
 * @des: 组织模块表单
 */
public class OrgForm {
    /**
     * 组织名称（只能字母和汉字）
     */
    @NotNull(message = "字段【name】必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入组织名称", groups = {InsertGroup.class})
    @Length(min = 3, max = 15, message = "组织名称在{min}~{max}个字符之间", groups = {InsertGroup.class})
    @Pattern(regexp = "^[\\u4e00-\\u9fa5a-zA-Z]+$", message = "组织名称只能字母和汉字", groups = {InsertGroup.class})
    private String name;
    /**
     * 描述
     */
    @NotNull(message = "字段【desc】必填", groups = {InsertGroup.class})
    @NotBlank(message = "请输入组织描述", groups = {InsertGroup.class})
    @Length(min = 3, max = 500, message = "组织简介在{min}~{max}个字符之间", groups = {InsertGroup.class})
    private String desc;

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
