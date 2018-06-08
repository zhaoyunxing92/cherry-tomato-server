package com.sunny.boot.cherrytomato.user.model;

import om.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByMapid extends BaseModel {
    private String mapId;

    private Byte type;

    private Long userId;

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId == null ? null : mapId.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}