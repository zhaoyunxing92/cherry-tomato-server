/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.model;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sunny
 * @date: 2019-10-23 17:32:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TxMsg extends BaseModel<String> {
    /**
     * 表示当前执行的动作
     */
    private String action;
}