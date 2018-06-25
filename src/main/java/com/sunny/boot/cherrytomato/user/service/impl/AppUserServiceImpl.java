/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.service.impl;

import com.sunny.boot.cherrytomato.user.mapper.AppUserMapper;
import com.sunny.boot.cherrytomato.user.model.AppUser;
import com.sunny.boot.cherrytomato.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.user.service.impl.AppUserServiceImpl
 * @date: 2018-06-25 18:25
 * @des:
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserMapper appUserMapper;

    /**
     * 根据用户id获取用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public AppUser getAppUser(Long userId) {
        return appUserMapper.selectAppUserByPrimaryKey(userId);
    }
}
