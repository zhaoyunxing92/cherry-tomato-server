package com.sunny.boot.cherrytomato.core.handler;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sunny.boot.cherrytomato.common.result.Response;
import com.sunny.boot.cherrytomato.core.exception.AppGlobalException;
import com.sunny.boot.cherrytomato.util.StringUtil;
import org.apache.ibatis.binding.BindingException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

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
            logger.error(httpMessageNotReadableException.getMessage());
            return new Response<>(102, "请求体为空，请输入参数");
        } else {
            return new Response<>(103, ex.getMessage());
        }
    }

    /**
     * mybatis 级别错误拦截
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({DuplicateKeyException.class, SQLException.class, BindingException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response mybatisSQLException(Exception ex) {

        if (ex instanceof SQLException) {
            //sql语法错误
            SQLException sqlException = (SQLException) ex;
            return new Response<>(200, sqlException.getMessage());
        } else if (ex instanceof BindingException) {
            //找不到对应的mapperxml文件id
            BindingException bindingException = (BindingException) ex;
            logger.error(bindingException.getMessage());
            return new Response<>(201, bindingException.getMessage());
        } else if (ex instanceof DuplicateKeyException) {
            // 组合唯一主键冲突 重复
            DuplicateKeyException duplicateKeyException = (DuplicateKeyException) ex;
            String msg = duplicateKeyException.getMessage();
            return new Response<>(202, msg.substring(msg.lastIndexOf(":") + 2));
        } else {
            return new Response<>(203, ex.getMessage());
        }
    }

    /**
     * 处理自定义异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({AppGlobalException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response mybatisSQLException(AppGlobalException ex) {
        return new Response<Response.Result>(ex.getResult());
    }
}
