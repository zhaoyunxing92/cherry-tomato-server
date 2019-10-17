package io.github.sunny.cherry.tomato.core.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体模型
 *
 * @author zhaoyunxing
 * @date: 2018-05-18 17:00
 */
@Data
public class BaseModel<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 720013901235423189L;
    /**
     * id
     */
    private ID id;

    /**
     * 用户状态(1=正常，8=冻结)
     */
    private Byte status;

    /**
     * 版本
     */
    private Integer versions;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date creatorTime;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 修改时间
     */
    private Date modifierTime;
}
