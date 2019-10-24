/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.github.sunny.cherry.tomato.account.dao.CherryAccountDao;
import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.model.CherryAccount;
import io.github.sunny.cherry.tomato.account.service.CherryAccountService;
import io.github.sunny.cherry.tomato.core.result.Response;
import io.github.sunny.cherry.tomato.core.utils.ResultUtil;
import io.github.sunny.cherry.tomato.security.service.CherryAccountRoleService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * 账户模块
 *
 * @author zhaoyunxing
 * @date: 2019-10-12 17:53
 */
@Service
@org.springframework.stereotype.Service
public class CherryAccountServiceImpl implements CherryAccountService {

    private final CherryAccountDao cherryAccountDao;
    private final RocketMQTemplate rocketMQTemplate;
    private final TxMsgService txMsgService;

    @Reference
    private CherryAccountRoleService cherryAccountRoleService;

    public CherryAccountServiceImpl(CherryAccountDao cherryAccountDao, RocketMQTemplate rocketMQTemplate, TxMsgService txMsgService) {
        this.cherryAccountDao = cherryAccountDao;
        this.rocketMQTemplate = rocketMQTemplate;
        this.txMsgService = txMsgService;
    }

    /**
     * 注册账户
     *
     * @param dto {@link CherryAccountDto}
     * @return {@link Response}
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Response register(CherryAccountDto dto) {
        // 添加账户
        Response<CherryAccount> cherryAccountResponse = cherryAccountDao.register(dto);
        //添加权限
        Response cherryAccountRoleDtoResponse = cherryAccountRoleService.assignRoles(cherryAccountResponse.getData().getId(), 1001L);

        if (cherryAccountResponse.isSuccess() && cherryAccountRoleDtoResponse.isSuccess()) {
            return ResultUtil.success("注册账户成功");
        }
        return ResultUtil.error("注册账户失败");
    }

    /**
     * 发送注册账号请求
     *
     * @param dto
     */
    @Override
    public void sendRegisterAction(CherryAccountDto dto) {
        String json = JSONObject.toJSONString(dto);

        Message<String> msg = MessageBuilder.withPayload(json).build();
        // 发送事物消息
        rocketMQTemplate.sendMessageInTransaction("producer_txmsg_account", "topic_txmsg", msg, null);
    }

    /**
     * 通过事物消息注册账号,这里需要作幂等
     *
     * @param txId
     * @param dto
     */
    @Override
    public Response msgRegister(String txId, CherryAccountDto dto) {
        String action = "register";
        if (txMsgService.isExists(txId, action)) {
            return ResultUtil.success("注册账户成功");
        }
        // 注册账号
        cherryAccountDao.register(dto);
        // 保存事物消息
        txMsgService.save(txId, action);
        return ResultUtil.success("注册账户成功");
    }

    /**
     * 登录
     *
     * @param dto {@link CherryAccountDto}
     * @return {@link Response} 信息
     */
    @Override
    public Response login(CherryAccountDto dto) {
        return null;
    }

    /**
     * 根据用户名称获取账号
     *
     * @param name 用户名
     * @return @link CherryAccountDto}
     */
    @Override
    public Response<CherryAccountDto> findAccountByUserName(String name) {
        CherryAccount account = cherryAccountDao.findAccountByUserName(name);
        if (Objects.isNull(account)) {
            return ResultUtil.success("查询账号成功", null);
        } else {
            CherryAccountDto dto = new CherryAccountDto();
            BeanUtils.copyProperties(account, dto);
            return ResultUtil.success("查询账号成功", dto);
        }
    }
}
