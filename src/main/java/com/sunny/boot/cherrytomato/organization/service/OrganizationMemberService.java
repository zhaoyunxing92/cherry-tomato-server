/**
 * Copyright(C) 2018 Hangzhou ${user} Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.service;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.organization.service.OrganizationMemberService
 * @date: 2018-06-25 17:12
 * @des: 团队添加成员
 */
public interface OrganizationMemberService {
    /**
     * 添加团队成员
     *
     * @param orgId  团队id
     * @param userId 用户id
     */
    void addOrganizationMember(Long orgId, Long userId);

    /**
     * 添加团队成员
     *
     * @param orgId  团队id
     * @param userId 用户id
     * @param auto   是否自动添加
     */
    void addOrganizationMember(Long orgId, Long userId, Boolean auto);

}
