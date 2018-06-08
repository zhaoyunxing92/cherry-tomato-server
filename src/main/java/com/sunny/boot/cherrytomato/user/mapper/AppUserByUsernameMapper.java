package com.sunny.boot.cherrytomato.user.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.user.model.AppUserByUsername;

public interface AppUserByUsernameMapper extends BaseMapper {
    int deleteByPrimaryKey(String username);

    int insert(AppUserByUsername record);

    int insertSelective(AppUserByUsername record);

    AppUserByUsername selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(AppUserByUsername record);

    int updateByPrimaryKey(AppUserByUsername record);
}