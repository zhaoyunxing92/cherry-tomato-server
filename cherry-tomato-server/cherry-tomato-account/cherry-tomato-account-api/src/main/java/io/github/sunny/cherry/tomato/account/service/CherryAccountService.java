/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.service;

import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.core.result.Response;

/**
 * @author zhaoyunxing
 * @date: 2019-10-12 17:52
 */
public interface CherryAccountService {
    /**
     * 注册账户
     *
     * @param dto {@link CherryAccountDto}
     * @return {@link Response} 信息
     */
    Response register(CherryAccountDto dto);

    /**
     * 发送注册账号请求
     *
     * @param dto
     */
    void sendRegisterAction(CherryAccountDto dto);

    /**
     * 通过事物消息注册账号
     *
     * @param txId 事物id号
     * @param dto
     */
    Response msgRegister(String txId, CherryAccountDto dto);


    /**
     * 登录
     *
     * @param dto {@link CherryAccountDto}
     * @return {@link Response} 信息
     */
    Response login(CherryAccountDto dto);

    /**
     * 根据用户名称获取账号
     *
     * @param name 用户名
     * @return @link CherryAccountDto}
     */
    Response<CherryAccountDto> findAccountByUserName(String name);
}
