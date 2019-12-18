package io.github.sunny.cherry.tomato.dingtalk.service.impl;

import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.DingTalkServer;
import io.github.sunny.cherry.tomato.dingtalk.dto.DingTalkUserInfoDto;
import io.github.sunny.cherry.tomato.dingtalk.req.DingTalkUserInfoReq;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 15:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DingTalkServer.class)
@Slf4j
public class DingTalkUserInfoServiceImplTest {
    @Reference
    private DingTalkUserInfoService dingTalkUserInfoService;

    private String corpId, appKey, code;

    @Before
    public void init() {
        corpId = "dingfe5fc7deb96c399e35c2f4657eb6378f";
        appKey = "dingsdw3uhysirwbmbxo";
        code = "3f2a9f8128e63578a18d8d0722252e5f";
    }

    @Test
    public void getDingTalkUserInfo() {
        DingTalkUserInfoReq req = new DingTalkUserInfoReq();
        req.setCorpId(corpId);
        req.setAppKey(appKey);
        req.setCode(code);
        Response<DingTalkUserInfoDto> dingTalkUserInfo = dingTalkUserInfoService.getDingTalkUserInfo(req);

        Assert.assertTrue(dingTalkUserInfo.isSuccess());
        log.info(dingTalkUserInfo.getData().toString());

    }
}
