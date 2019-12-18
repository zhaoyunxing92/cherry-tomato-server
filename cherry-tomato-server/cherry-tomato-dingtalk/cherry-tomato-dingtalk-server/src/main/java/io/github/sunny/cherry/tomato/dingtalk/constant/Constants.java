/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.constant;

/**
 * @author zhaoyunxing
 * @date: 2019-12-17 19:05
 * @desc:
 */
public class Constants {

    private static final String dingTalk = "https://oapi.dingtalk.com";
    /**
     * 获取token
     */
    public static final String get_token = dingTalk + "/gettoken";
    /**
     * 获取用户id
     */
    public static final String get_user_id = dingTalk + "/user/getuserinfo";
    /**
     * 获取用户信息
     */
    public static final String get_user_info = dingTalk + "/user/get";
}
