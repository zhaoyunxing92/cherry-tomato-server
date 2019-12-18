/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.service.impl;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;
import io.github.sunny.cherry.tomato.core.exception.AppServiceException;
import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.dingtalk.constant.Constants;
import io.github.sunny.cherry.tomato.dingtalk.dto.DingTalkUserInfoDto;
import io.github.sunny.cherry.tomato.dingtalk.req.DingTalkUserInfoReq;
import io.github.sunny.cherry.tomato.dingtalk.service.AccessTokenService;
import io.github.sunny.cherry.tomato.dingtalk.service.DingTalkUserInfoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zhaoyunxing
 * @date: 2019-12-18 13:16
 * @desc:
 */
@Service(interfaceClass = DingTalkUserInfoService.class)
public class DingTalkUserInfoServiceImpl implements DingTalkUserInfoService {

    private final AccessTokenService accessTokenService;

    public DingTalkUserInfoServiceImpl(AccessTokenService accessTokenService) {
        this.accessTokenService = accessTokenService;
    }

    /**
     * 获取钉钉用户信息
     *
     * @param req 企业信息
     * @return DingTalkUserInfoDto
     */
    @Override
    public Response<DingTalkUserInfoDto> getDingTalkUserInfo(DingTalkUserInfoReq req) {
        String accessToken = accessTokenService.getAccessToken(req.getCorpId(), req.getAppKey());
        // 获取用户id
        String userId = getUserId(accessToken, req.getCode());
        DingTalkUserInfoDto userInfo = getUserInfo(accessToken, userId);
        return Response.success("获取用户信息成功",userInfo);
    }

    /**
     * 获取用户id
     *
     * @param accessToken
     * @param code
     * @return
     */
    private String getUserId(String accessToken, String code) {

        try {
            DingTalkClient client = new DefaultDingTalkClient(Constants.get_user_id);
            OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
            request.setCode(code);
            request.setHttpMethod("GET");
            OapiUserGetuserinfoResponse response = client.execute(request, accessToken);
            Long errcode = response.getErrcode();
            if (errcode != 0) {
                throw new AppServiceException(Response.error(errcode, response.getErrmsg()));
            }
            return response.getUserid();
        } catch (ApiException ex) {
            throw new AppServiceException(Response.error(500, ex.getErrMsg()));
        }

    }

    private DingTalkUserInfoDto getUserInfo(String accessToken, String userId) {
        try {
            DingTalkClient client = new DefaultDingTalkClient(Constants.get_user_info);
            OapiUserGetRequest request = new OapiUserGetRequest();
            request.setUserid(userId);
            request.setHttpMethod("GET");
            OapiUserGetResponse response = client.execute(request, accessToken);
            Long errcode = response.getErrcode();
            if (errcode != 0) {
                throw new AppServiceException(Response.error(errcode, response.getErrmsg()));
            }
            return JSON.parseObject(response.getBody(), DingTalkUserInfoDto.class);
        } catch (ApiException ex) {
            throw new AppServiceException(Response.error(500, ex.getErrMsg()));
        }
    }
}
