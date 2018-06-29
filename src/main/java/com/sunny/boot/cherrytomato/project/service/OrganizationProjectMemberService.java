/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.service;

import com.sunny.boot.cherrytomato.common.result.Response;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.service.OrganizationProjectMemberService
 * @date: 2018-06-29 10:49
 * @des: 项目成员接口
 */
public interface OrganizationProjectMemberService {
    /**
     * 项目添加成员
     *
     * @param proId  项目id
     * @param userId 用户id
     * @return
     */
    void addOrgProjectMember(Long proId, Long userId);

    /**
     * 项目添加成员
     *
     * @param proId  项目id
     * @param userId 用户id
     * @param auto   是否自动添加
     */
    void addOrgProjectMember(Long proId, Long userId, Boolean auto);
}
