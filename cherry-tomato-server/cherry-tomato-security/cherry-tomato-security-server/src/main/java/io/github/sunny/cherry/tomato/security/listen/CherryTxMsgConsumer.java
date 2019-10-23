/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.listen;

import io.github.sunny.cherry.tomato.security.service.CherryAccountRoleService;
import io.github.sunny.cherry.tomato.security.service.impl.TxMsgService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

/**
 * @author zhaoyunxing
 * @date: 2019-10-23 17:47
 */
@Component
@RocketMQMessageListener(consumerGroup = "", topic = "topic_txmsg")
public class CherryTxMsgConsumer implements RocketMQListener<Message> {

    private final CherryAccountRoleService cherryAccountRoleService;
    private final TxMsgService txMsgService;

    public CherryTxMsgConsumer(CherryAccountRoleService cherryAccountRoleService, TxMsgService txMsgService) {
        this.cherryAccountRoleService = cherryAccountRoleService;
        this.txMsgService = txMsgService;
    }

    /**
     * 接受到消息
     *
     * @param msg
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void onMessage(Message msg) {
        String txId = Objects.requireNonNull(msg.getHeaders().getId()).toString();
        if (txMsgService.isExists(txId, "AssignRoles")) {
            return;
        }
        cherryAccountRoleService.msgAssignRoles(1005L, 1005L);
        txMsgService.save(txId, "AssignRoles");
    }
}
