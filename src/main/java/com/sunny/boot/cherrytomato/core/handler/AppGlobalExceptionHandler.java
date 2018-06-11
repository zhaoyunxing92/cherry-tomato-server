package com.sunny.boot.cherrytomato.core.handler;

import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.util.ConstraintViolationExceptionHandler;
import com.sunny.boot.cherrytomato.util.StringUtil;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.core.handler.AppGlobalExceptionHandler
 * @date: 2018-06-08 13:51
 * @des: 统一异常处理
 */
@ControllerAdvice
public class AppGlobalExceptionHandler {
  private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AppGlobalExceptionHandler.class);

  // MyBatisSystemException nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named 'open' in 'class com.sunny.bugmanage.project.form.ProjectForm
  @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class, HttpMessageNotReadableException.class, MyBatisSystemException.class})
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Response validExceptionHandle(Exception ex) {

    if (ex instanceof BindException) {
      BindException bingException = (BindException) ex;
      return new Response<>(100, StringUtil.errorsToString(bingException.getAllErrors()));
    } else if (ex instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
      return new Response<>(101, StringUtil.errorsToString(methodArgumentNotValidException.getBindingResult().getAllErrors()));
    } else if (ex instanceof HttpMessageNotReadableException) {
      HttpMessageNotReadableException httpMessageNotReadableException = (HttpMessageNotReadableException) ex;
      return new Response<>(100, httpMessageNotReadableException.getMessage());
    } else {
      return new Response<>(100, ex.getMessage());
    }
  }

}
