/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.user.model.AppUserByUsername;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserByUsernameMapper extends BaseMapper<AppUserByUsername, String> {
  /**
   * 根据用户名获取用户用户id
   *
   * @param userName 用户名
   * @return
   */
  Long selectUserIdByPrimaryKey(@Param("username") String userName);
}