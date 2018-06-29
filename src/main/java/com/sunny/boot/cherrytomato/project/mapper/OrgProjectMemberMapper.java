/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.project.model.OrgProjectMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgProjectMemberMapper extends BaseMapper<OrgProjectMember, Long> {
    /**
     * 获取项目成员id
     *
     * @param proId 项目id
     * @return 项目成员id
     */
    List<Long> selectProjectMemberId(@Param("proId") Long proId);
}