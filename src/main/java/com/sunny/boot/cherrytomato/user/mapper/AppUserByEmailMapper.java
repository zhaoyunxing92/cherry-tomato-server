/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.user.model.AppUserByEmail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserByEmailMapper extends BaseMapper<AppUserByEmail, String> {
  /**
   * 根据邮箱获取用户id
   * @param email
   * @return
   */
  Long selectUserIdByPrimaryKey(@Param("email") String email);
}