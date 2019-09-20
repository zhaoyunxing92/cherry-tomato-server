/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.core.common.form;

import io.github.sunny.cherry.tomato.core.common.valid.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zhaoyunxing
 * @date: 2019-09-20 14:27
 */
@Data
public class BaseForm<ID extends Serializable> {

    @NotNull(message = "字段[id]必填", groups = {UpdateGroup.class})
    private ID id;

}
