package io.github.sunny.cherry.tomato.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author sunny
 * @date: 2018-06-06 13:57
 */
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 393612537159594290L;

    private String traceId;
    /**
     * code
     */
    private long code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 失败
     *
     * @param code
     * @param msg
     * @return
     */
    public static  Response<?> error(long code, String msg) {
        return new Response("", code, msg, null, false);
    }

    /**
     * 成功
     *
     * @param msg
     * @return
     */
    public static Response success(String msg, Object obj) {
        return  new Response("", 0, msg, obj, true);
    }
}
