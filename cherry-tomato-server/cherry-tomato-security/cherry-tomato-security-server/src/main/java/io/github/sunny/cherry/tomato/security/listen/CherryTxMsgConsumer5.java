/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.security.listen;

import io.github.sunny.cherry.tomato.security.service.CherryAccountRoleService;
import io.github.sunny.cherry.tomato.security.service.impl.TxMsgService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhaoyunxing
 * @date: 2019-10-23 17:47
 */
@Service
@RocketMQMessageListener(topic = "test", consumerGroup = "security_consumer_5")
public class CherryTxMsgConsumer5 implements RocketMQListener<String> {

    private final CherryAccountRoleService cherryAccountRoleService;
    private final TxMsgService txMsgService;

    public CherryTxMsgConsumer5(CherryAccountRoleService cherryAccountRoleService, TxMsgService txMsgService) {
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
    public void onMessage(String msg) {
        System.out.println(msg);

        //        String txId = Objects.requireNonNull(msg.getHeaders().getId()).toString();
        //        if (txMsgService.isExists(txId, "AssignRoles")) {
        //            return;
        //        }
        //        cherryAccountRoleService.msgAssignRoles(1005L, 1005L);
        //        txMsgService.save(txId, "AssignRoles");
    }
}
