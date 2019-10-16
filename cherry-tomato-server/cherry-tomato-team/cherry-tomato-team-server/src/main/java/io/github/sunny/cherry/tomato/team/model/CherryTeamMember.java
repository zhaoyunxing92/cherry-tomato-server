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
public class CherryTeamMember extends BaseModel<Long> {
    /**
     * 团队id
     */
    private Long teamId;

    /**
     * 成员id
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 0=成员，1=管理员
     */
    private Boolean manage;
}