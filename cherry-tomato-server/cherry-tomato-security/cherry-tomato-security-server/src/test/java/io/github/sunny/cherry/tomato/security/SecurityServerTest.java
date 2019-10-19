package io.github.sunny.cherry.tomato.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 12:56
 */
public class SecurityServerTest {

    /**
     * 加密码密码
     */
    @Test
    public void contextLoads() {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        System.out.println(bcrypt.encode("123456"));
        System.out.println(bcrypt.encode("123456"));
    }
}