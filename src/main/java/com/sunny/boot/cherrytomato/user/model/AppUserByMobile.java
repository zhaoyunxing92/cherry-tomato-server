package com.sunny.boot.cherrytomato.user.model;

import om.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByMobile extends BaseModel {
    private Long mobile;

    private Long userId;

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}