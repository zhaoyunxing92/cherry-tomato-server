/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.organization.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.organization.model.Organization;
import com.sunny.boot.cherrytomato.organization.model.vo.OrganizationVo;
<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Param;
>>>>>>> 911c31910060857dfa9937966c4fc67821350360
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationMapper extends BaseMapper<Organization, Long> {
    /**
<<<<<<< HEAD
     * 根据用户id获取团队列表
     *
     * @param userId
     * @param name
     * @return
     */
    List<OrganizationVo> selectOrganizationByUserId(Long userId, String name);
=======
     * 获取当前登陆人的团队
     *
     * @param userId 用户id
     * @param name   团队名称
     * @return 团队
     */
    List<OrganizationVo> selectCurrentOrganization(@Param("userId") Long userId, @Param("name") String name);
>>>>>>> 911c31910060857dfa9937966c4fc67821350360
}