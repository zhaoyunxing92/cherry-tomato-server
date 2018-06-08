package com.sunny.boot.cherrytomato.user.mapper;

import com.sunny.boot.cherrytomato.common.mapper.BaseMapper;
import com.sunny.boot.cherrytomato.user.model.AppUserByMapid;

public interface AppUserByMapidMapper extends BaseMapper {
    int insert(AppUserByMapid record);

    int insertSelective(AppUserByMapid record);
}