package io.github.sunny.cherry.tomato.core.exception;

import io.github.sunny.cherry.tomato.core.result.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 全局异常
 *
 * @author sunny
 * @date: 2018-05-18 13:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AppGlobalException extends RuntimeException {
    private static final long serialVersionUID = -4901434558868605358L;

    private Response response;

    public AppGlobalException(Response response) {
        this.response = response;
    }

    public AppGlobalException(Response response, Object... args) {
        String msg = response.getMsg();
        this.response = response;
        this.response.setMsg(String.format(msg, args));
    }

}
