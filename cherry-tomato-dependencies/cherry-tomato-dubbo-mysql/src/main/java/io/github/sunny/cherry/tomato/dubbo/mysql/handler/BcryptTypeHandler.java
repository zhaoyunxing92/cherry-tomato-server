/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dubbo.mysql.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Bcrypt 加密
 *
 * @author zhaoyunxing
 * @date: 2019-10-16 17:23
 */
public class BcryptTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String parameter, JdbcType jdbcType) throws SQLException {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encode = bcrypt.encode(parameter);
        preparedStatement.setString(i, encode);
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String parameter) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
