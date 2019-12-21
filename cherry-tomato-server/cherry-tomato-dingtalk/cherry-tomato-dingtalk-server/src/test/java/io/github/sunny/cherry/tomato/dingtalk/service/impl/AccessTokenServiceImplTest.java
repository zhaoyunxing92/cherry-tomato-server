package io.github.sunny.cherry.tomato.dingtalk.service.impl;


import io.github.sunny.cherry.tomato.dingtalk.CherryDingTalkServer;
import io.github.sunny.cherry.tomato.dingtalk.service.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 14:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CherryDingTalkServer.class)
@Slf4j
public class AccessTokenServiceImplTest {

    @Autowired
    private AccessTokenService accessTokenService;

    private String corpId, appKey;

    @Before
    public void init() {
        corpId = "dingfe5fc7deb96c399e35c2f4657eb6378f";
        appKey = "dingsdw3uhysirwbmbxo";
    }

    @Test
    public void getAccessToken() {
        String accessToken = accessTokenService.getAccessToken(corpId, appKey);
        Assert.assertNotNull(accessToken);
    }
}