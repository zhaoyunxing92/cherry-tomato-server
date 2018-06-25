/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.service;

import com.sunny.boot.cherrytomato.user.model.AppUser;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.user.service.AppUserService
 * @date: 2018-06-25 18:24
 * @des: 系统用户模块
 */
public interface AppUserService {
    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    AppUser getAppUser(Long userId);
}
