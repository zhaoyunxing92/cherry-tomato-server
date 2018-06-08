package com.sunny.boot.cherrytomato.user.model;

import om.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByEmail extends BaseModel {
    private String email;

    private Long userId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}