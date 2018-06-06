package com.sunny.boot.cherrytomato.util;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunny
 * @class: com.sunny.workflow.users.util.ConstraintViolationExceptionHandler
 * @date: 2018-05-18 0:46
 * @des: 处理数据校验
 */
public class ConstraintViolationExceptionHandler {
  private ConstraintViolationExceptionHandler() {
  }

  /**
   * 验证异常信息转化string
   *
   * @param ex
   * @return
   */
  public static String getMessage(ConstraintViolationException ex) {
    List<String> msg = new ArrayList<>();
    for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
      msg.add(constraintViolation.getMessage());
    }
    return String.join(" ; ", msg);
  }
}
