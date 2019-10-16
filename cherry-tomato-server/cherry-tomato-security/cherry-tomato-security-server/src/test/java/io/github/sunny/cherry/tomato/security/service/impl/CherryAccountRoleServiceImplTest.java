package io.github.sunny.cherry.tomato.security.service.impl;

import io.github.sunny.cherry.tomato.security.service.CherryAccountRoleService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhaoyunxing
 * @date: 2019-10-16 14:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CherryAccountRoleServiceImplTest {

    @Reference
    private CherryAccountRoleService cherryAccountRoleService;

    @Test
    public void assignRoles() {
        cherryAccountRoleService.assignRoles(1005L, 1001L);
    }
}