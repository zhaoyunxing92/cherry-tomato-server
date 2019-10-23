/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.cherry.tomato.account.service.impl;


import io.github.sunny.cherry.tomato.account.mapper.TxMsgMapper;
import io.github.sunny.cherry.tomato.account.model.TxMsg;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyunxing
 * @date: 2019-10-23 17:29
 */
@Service
public class TxMsgService {

    private final TxMsgMapper txMsgMapper;

    public TxMsgService(TxMsgMapper txMsgMapper) {this.txMsgMapper = txMsgMapper;}

    /**
     * 保存事物消息
     *
     * @param txId   事物id
     * @param action 动作
     */
    void save(String txId, String action) {
        TxMsg msg = new TxMsg();
        msg.setAction(action);
        msg.setId(txId);
        txMsgMapper.insertSelective(msg);
    }

    /**
     * 判断事物是否执行
     *
     * @param txId
     * @param action
     * @return 存在返回true
     */
    public boolean isExists(String txId, String action) {
        TxMsg txMsg = txMsgMapper.selectByPrimaryKey(txId);
        return txMsg.getAction().equals(action);
    }
}
