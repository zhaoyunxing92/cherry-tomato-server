/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.project.model.OrgProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgProjectMapper extends BaseMapper<OrgProject, Long> {
    /**
     * 根据团队id获取项目个数
     *
     * @param orgId
     * @return
     */
    int selectProjectCount(@Param("orgId") Long orgId);
}