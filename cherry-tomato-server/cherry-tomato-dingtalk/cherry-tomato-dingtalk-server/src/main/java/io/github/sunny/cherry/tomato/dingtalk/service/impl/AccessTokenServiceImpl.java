/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import io.github.sunny.cherry.tomato.core.exception.AppServiceException;
import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.constant.Constants;
import io.github.sunny.cherry.tomato.dingtalk.dao.MicroAppTokenDao;
import io.github.sunny.cherry.tomato.dingtalk.model.AccessToken;
import io.github.sunny.cherry.tomato.dingtalk.model.MicroApp;
import io.github.sunny.cherry.tomato.dingtalk.service.AccessTokenService;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkMicroAppService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

/**
 * token服务
 *
 * @author zhaoyunxing
 * @date: 2019-12-18 13:21
 */
@Service
public class AccessTokenServiceImpl implements AccessTokenService {

    private final MicroAppTokenDao microAppTokenDao;
    private final DingTalkMicroAppService dingTalkMicroAppService;

    public AccessTokenServiceImpl(MicroAppTokenDao microAppTokenDao, DingTalkMicroAppService dingTalkMicroAppService) {
        this.microAppTokenDao = microAppTokenDao;
        this.dingTalkMicroAppService = dingTalkMicroAppService;
    }

    /**
     * 获取token
     *
     * @param corpId 企业id
     * @param appKey 小程序key
     * @return token
     */
    @Override
    public String getAccessToken(String corpId, String appKey) {
        MicroApp microApp = dingTalkMicroAppService.selectMicroApp(corpId, appKey);

        Assert.notNull(microApp, String.format("该企业[%s]小的小程序[%s]没有登记", corpId, appKey));
        AccessToken accessToken = microAppTokenDao.findByCorpIdAndAppKey(corpId, appKey);

        if (Objects.isNull(accessToken)) {
            accessToken = dingTalkAccessToken(microApp.getAppKey(), microApp.getAppSecret());
            accessToken.setCorpId(corpId);
            accessToken.setCreatorTime(new Date());
            accessToken.setModifierTime(new Date());
            microAppTokenDao.save(accessToken);
        } else if (ChronoUnit.SECONDS.between(accessToken.getModifierTime().toInstant(), Instant.now()) >= accessToken.getExpiresIn()-1) {
            AccessToken token = dingTalkAccessToken(microApp.getAppKey(), microApp.getAppSecret());
            accessToken.setAccessToken(token.getAccessToken());
            accessToken.setExpiresIn(token.getExpiresIn());
            accessToken.setModifierTime(new Date());
            microAppTokenDao.save(accessToken);
        }
        return accessToken.getAccessToken();
    }

    /**
     * 钉钉接口获取token
     *
     * @param appKey    appid
     * @param appSecret 秘钥
     * @return AccessToken
     */
    private AccessToken dingTalkAccessToken(String appKey, String appSecret) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(Constants.get_token);
            OapiGettokenRequest request = new OapiGettokenRequest();

            request.setAppkey(appKey);
            request.setAppsecret(appSecret);
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            Long code = response.getErrcode();
            if (code != 0) {
                throw new AppServiceException(code, response.getErrmsg());
            }
            //计算token过期时间 7200-200
            AccessToken token = new AccessToken();
            token.setAccessToken(response.getAccessToken());
            token.setAppKey(appKey);
            token.setExpiresIn(response.getExpiresIn());
            return token;
        } catch (ApiException ex) {
            throw new AppServiceException(Response.error(500, ex.getErrMsg()));
        }
    }
}
