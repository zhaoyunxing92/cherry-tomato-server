/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.core.common.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhaoyunxing
 * @date: 2019-09-20 14:27
 */
@Setter
@Getter
public class BaseForm<ID extends Serializable> {

    //    @NotNull(message = "字段[id]必填", groups = {UpdateGroup.class})
    private ID id;

}
