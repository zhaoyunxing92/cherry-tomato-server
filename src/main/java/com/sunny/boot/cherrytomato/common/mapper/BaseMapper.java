package com.sunny.boot.cherrytomato.common.mapper;

import com.sunny.boot.cherrytomato.common.model.BaseModel;

import java.io.Serializable;

/**
 * @author sunny
 * @class: com.sunny.workflow.user.common.mapper.BaseMapper
 * @date: 2018-05-18 17:07
 * @des:
 */
public interface BaseMapper<T extends BaseModel<ID>, ID extends Serializable> {
    long deleteByPrimaryKey(ID id);

    long insert(T record);

    long insertSelective(T record);

    T selectByPrimaryKey(ID id);

    long updateByPrimaryKeySelective(T record);

    long updateByPrimaryKey(T record);
}
