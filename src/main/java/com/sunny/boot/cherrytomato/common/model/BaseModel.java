package com.sunny.boot.cherrytomato.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunny
 * @class: com.sunny.workflow.user.common.model.BaseModel
 * @date: 2018-05-18 17:00
 * @des:
 */
public class BaseModel<ID extends Serializable> implements Serializable {

  private static final long serialVersionUID = 720013901235423189L;
  private ID id;

  private Long creator;

  private Date createTime;

  private Long modifier;

  private Date modifyTime;



}
