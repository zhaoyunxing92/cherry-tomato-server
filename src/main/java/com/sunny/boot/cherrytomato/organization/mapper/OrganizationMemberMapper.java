/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.organization.model.OrganizationMember;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationMemberMapper extends BaseMapper<OrganizationMember, Long> {
}