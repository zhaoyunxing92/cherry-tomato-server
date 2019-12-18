/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.dingtalk.model;

/**
 * @author zhaoyunxing
 * @date: 2019-12-17 18:02
 * @desc:
 */
//@Service
//public class DingTalkService {
//
//    private final DingTalkProperties dingTalkProperties;
//
//    public DingTalkService(DingTalkProperties dingTalkProperties) {
//        this.dingTalkProperties = dingTalkProperties;
//    }
//
//    private AccessToken getAccessToken() {
//        try {
//            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
//            OapiGettokenRequest request = new OapiGettokenRequest();
//
//            request.setAppkey(dingTalkProperties.getAppkey());
//            request.setAppsecret(dingTalkProperties.getAppSecret());
//            request.setHttpMethod("GET");
//            OapiGettokenResponse response = client.execute(request);
//            String accessToken = response.getAccessToken();
//
//            System.out.println(accessToken);
//            return new AccessToken();
//        } catch (ApiException ex) {
//            throw new AppServiceException(Response.error(500, ex.getErrMsg()));
//        }
//    }
//}
