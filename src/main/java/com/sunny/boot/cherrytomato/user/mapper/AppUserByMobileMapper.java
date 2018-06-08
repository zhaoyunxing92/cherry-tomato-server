package com.sunny.boot.cherrytomato.user.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.user.model.AppUserByMobile;

public interface AppUserByMobileMapper extends BaseMapper {
    int deleteByPrimaryKey(Long mobile);

    int insert(AppUserByMobile record);

    int insertSelective(AppUserByMobile record);

    AppUserByMobile selectByPrimaryKey(Long mobile);

    int updateByPrimaryKeySelective(AppUserByMobile record);

    int updateByPrimaryKey(AppUserByMobile record);
}