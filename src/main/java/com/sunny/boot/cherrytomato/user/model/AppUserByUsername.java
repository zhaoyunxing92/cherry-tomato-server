package com.sunny.boot.cherrytomato.user.model;

import om.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByUsername extends BaseModel {
    private String username;

    private Long userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}