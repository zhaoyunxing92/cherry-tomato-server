package com.sunny.boot.cherrytomato.user.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.user.model.AppUserByEmail;

public interface AppUserByEmailMapper extends BaseMapper {
    int deleteByPrimaryKey(String email);

    int insert(AppUserByEmail record);

    int insertSelective(AppUserByEmail record);

    AppUserByEmail selectByPrimaryKey(String email);

    int updateByPrimaryKeySelective(AppUserByEmail record);

    int updateByPrimaryKey(AppUserByEmail record);
}