/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.project.service.impl;

import com.sunny.boot.cherrytomato.project.mapper.OrgProjectMemberMapper;
import com.sunny.boot.cherrytomato.project.model.OrgProjectMember;
import com.sunny.boot.cherrytomato.project.service.OrgProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaoyunxing
 * @class: com.sunny.boot.cherrytomato.project.service.impl.OrgProjectMemberServiceImpl
 * @date: 2018-06-29 13:05
 * @des:
 */
@Service
public class OrgProjectMemberServiceImpl implements OrgProjectMemberService {
    @Autowired
    private OrgProjectMemberMapper orgProjectMemberMapper;

    @Override
    public void addOrgProjectMember(Long proId, Long userId) {
        addOrgProjectMember(proId, userId, false);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addOrgProjectMember(Long proId, Long userId, Boolean auto) {
        OrgProjectMember member = new OrgProjectMember();
        member.setProjectId(proId);
        member.setUserId(userId);
        member.setIsManage(auto);
        orgProjectMemberMapper.insertSelective(member);
    }
}
