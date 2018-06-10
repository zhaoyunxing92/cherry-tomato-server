/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.model;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

public class AppUserByMapid extends BaseModel<String> {
    /**
     * 第三方openid md5值
     */
    private String mapId;

    /**
     * 第三方类型(1=dd)
     */
    private Byte type;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * app_user_by_mapid
     */
    private static final long serialVersionUID = 1L;

    /**
     * 第三方openid md5值
     * @return mapId 第三方openid md5值
     */
    public String getMapId() {
        return mapId;
    }

    /**
     * 第三方openid md5值
     * @param mapId 第三方openid md5值
     */
    public void setMapId(String mapId) {
        this.mapId = mapId == null ? null : mapId.trim();
    }

    /**
     * 第三方类型(1=dd)
     * @return type 第三方类型(1=dd)
     */
    public Byte getType() {
        return type;
    }

    /**
     * 第三方类型(1=dd)
     * @param type 第三方类型(1=dd)
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 用户id
     * @return userId 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}