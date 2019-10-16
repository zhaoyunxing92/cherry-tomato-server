package io.github.sunny.cherry.tomato.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 12:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityServerTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
        System.out.println("====>" + dataSource);
    }
}