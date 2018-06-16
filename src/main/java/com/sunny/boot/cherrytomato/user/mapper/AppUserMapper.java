/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.user.model.AppUser;
import com.sunny.boot.cherrytomato.user.model.vo.AppUserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserMapper extends BaseMapper<AppUser, Long> {
  /**
   * 根据用户id获取用户
   *
   * @param userId
   * @return
   */
  AppUserVo selectAppUserByPrimaryKey(@Param("id") Long userId);
}