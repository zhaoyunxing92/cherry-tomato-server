/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.organization.model.Organization;
import com.sunny.boot.cherrytomato.organization.model.vo.OrganizationVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationMapper extends BaseMapper<Organization, Long> {
    /**
     * 根据用户id获取团队列表
     *
     * @param userId
     * @param name
     * @return
     */
    List<OrganizationVo> selectOrganizationByUserId(@Param("userId") Long userId, @Param("name") String name);

}