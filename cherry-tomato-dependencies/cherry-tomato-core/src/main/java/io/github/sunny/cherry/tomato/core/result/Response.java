package io.github.sunny.cherry.tomato.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * @author sunny
 * @date: 2018-06-06 13:57
 */
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 393612537159594290L;
    /**
     * 消息
     */
    private String msg;

    /**
     * 请求url
     */
    private String url;
    /**
     * 数据
     */
    private T data;
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 是否有数据
     *
     * @return 有数据返回true
     */
    public boolean hasData() {
        if (data instanceof Collection) {
            return !((Collection) data).isEmpty();
        } else if (data instanceof Object[]) {
            return ((Object[]) data).length > 0;
        }
        return Objects.nonNull(data);
    }
}
