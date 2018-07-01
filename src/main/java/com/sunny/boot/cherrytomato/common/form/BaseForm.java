package com.sunny.boot.cherrytomato.common.form;

import com.sunny.boot.cherrytomato.common.valid.UpdateGroup;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.common.form.BaseForm
 * @date: 2018-06-08 16:51
 * @des:
 */
public class BaseForm<ID extends Serializable> {
    @NotNull(message = "字段[id]必填", groups = {UpdateGroup.class})
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
