/**
 * Copyright(C) 2019 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.team.model;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sunny
 * @date: 2019-10-15 14:56:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CherryTeam extends BaseModel<Long> {
    /**
     * 团队名称
     */
    private String name;

    /**
     * 团队介绍
     */
    private String intro;

    /**
     * 团队logo地址
     */
    private String avatar;

    /**
     * 团队最多容纳人员
     */
    private Integer limitMember;
}