/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.listen;

import com.alibaba.fastjson.JSONObject;
import io.github.sunny.cherry.tomato.account.dto.CherryAccountDto;
import io.github.sunny.cherry.tomato.account.service.CherryAccountService;
import io.github.sunny.cherry.tomato.account.service.impl.TxMsgService;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * 监听rocket mq事物
 *
 * @author zhaoyunxing
 * @date: 2019-10-22 18:07
 */
@Component
@RocketMQTransactionListener(txProducerGroup = "producer_txmsg_account")
public class AccountRocketMQTransactionListener implements RocketMQLocalTransactionListener {

    private final CherryAccountService cherryAccountService;
    private final TxMsgService txMsgService;

    public AccountRocketMQTransactionListener(CherryAccountService cherryAccountService, TxMsgService txMsgService) {
        this.cherryAccountService = cherryAccountService;
        this.txMsgService = txMsgService;
    }

    /**
     * 执行本地事物
     *
     * @param msg
     * @param arg
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {

        try {
            String payload = new String((byte[]) msg.getPayload());
            CherryAccountDto dto = JSONObject.parseObject(payload, CherryAccountDto.class);
            cherryAccountService.msgRegister(Objects.requireNonNull(msg.getHeaders().getId()).toString(), dto);
            // 提交commit后消息可以消费
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    /**
     * 事物回查
     *
     * @param msg
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        if (txMsgService.isExists(Objects.requireNonNull(msg.getHeaders().getId()).toString(), "register")) {
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.UNKNOWN;
    }
}
