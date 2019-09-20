package io.github.sunny.cherry.tomato.core.common.mapper;

import io.github.sunny.cherry.tomato.core.common.model.BaseModel;

import java.io.Serializable;

/**
 * 基础mybatis操作
 *
 * @author sunny
 * @date: 2018-05-18 17:07
 */
public interface BaseMapper<T extends BaseModel<ID>, ID extends Serializable> {
    
    /**
     * 根据id删除
     *
     * @param id id
     * @return 返回影响行数
     */
    int deleteByPrimaryKey(ID id);

    /**
     * 插入实体
     *
     * @param record 实体
     * @return 返回影响行数
     */
    int insertSelective(T record);

    /**
     * 根据id查询实体
     *
     * @param id id
     * @return T
     */
    T selectByPrimaryKey(ID id);

    /**
     * 更新实体
     *
     * @param record T
     * @return 返回影响行数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 更新实体
     *
     * @param record T
     * @return 返回影响行数
     */
    int updateByPrimaryKey(T record);
}
