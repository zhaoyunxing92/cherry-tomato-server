/**
 * Copyright(C) 2018 Hangzhou sunny Technology Co., Ltd. All rights reserved.
 */
package com.sunny.boot.cherrytomato.user.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.user.model.AppUserByMobile;
import org.apache.ibatis.annotations.Param;

public interface AppUserByMobileMapper extends BaseMapper<AppUserByMobile, Long> {
  /**
   * 根据手机号获取用户id
   *
   * @param mobile 手机号
   * @return 返回用户id
   */
  Long selectUserIdByPrimaryKey(@Param("mobile") Long mobile);
}