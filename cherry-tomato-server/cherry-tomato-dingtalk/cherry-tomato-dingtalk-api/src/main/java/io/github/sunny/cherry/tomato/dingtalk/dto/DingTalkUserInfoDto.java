/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.dto;

import io.github.sunny.cherry.tomato.core.common.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * {
 * "errcode": 0,
 * "unionid": "a5yu47xgYQIzH1QwejV4WAiEiE",
 * "openId": "a5yu47xgYQIzH1QwejV4WAiEiE",
 * "remark": "",
 * "userid": "010123516638658715",
 * "isLeaderInDepts": "{37005251:false}",
 * "isBoss": false,
 * "isSenior": false,
 * "tel": "",
 * "department": [
 * 37005251
 * ],
 * "workPlace": "",
 * "email": "",
 * "orderInDepts": "{37005251:176341033252709512}",
 * "mobile": "16657101218",
 * "errmsg": "ok",
 * "active": true,
 * "avatar": "https://static-legacy.dingtalk.com/media/lADPDgQ9q3yvuFHNAeDNAkU_581_480.jpg",
 * "isAdmin": false,
 * "tags": {},
 * "isHide": false,
 * "jobnumber": "",
 * "name": "马传鹏",
 * "stateCode": "86",
 * "position": ""
 * }
 *
 * @author zhaoyunxing
 * @date: 2019-12-18 02:41
 * @desc:
 */
@Getter
@Setter
@ToString
public class DingTalkUserInfoDto extends BaseDto {

    /**
     * 姓名
     */
    private String name;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 头像
     */
    private String avatar;

}
