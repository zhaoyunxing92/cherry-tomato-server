/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.organization.model.OrganizationMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationMemberMapper extends BaseMapper<OrganizationMember, Long> {
    /**
     * 获取团队成员id
     *
     * @param orgId 团队id
     * @return 返回当前团队成员id
     */
    List<Long> selectOrganizationMemberId(@Param("orgId") Long orgId);

    /**
     * 根据团队id和成员id删除成员
     *
     * @param orgId  团队id
     * @param userId 成员id
     */
    void delOrganizationMemberByOrgIdAndUserId(@Param("orgId") Long orgId,@Param("userId") Long userId);
}