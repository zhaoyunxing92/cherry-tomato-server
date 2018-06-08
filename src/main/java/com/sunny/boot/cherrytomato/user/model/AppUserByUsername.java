package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByUsername extends BaseModel<String> {
    private static final long serialVersionUID = 2394368122540552809L;
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