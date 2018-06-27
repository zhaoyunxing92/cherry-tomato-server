package com.sunny.boot.cherrytomato.core.exception;

import static com.sunny.boot.cherrytomato.common.result.Response.Result;

/**
 * @author sunny
 * @class: com.sunny.workflow.user.exception.AppGlobalException
 * @date: 2018-05-18 13:31
 * @des: 全局异常
 */
public class AppGlobalException extends RuntimeException {
    private static final long serialVersionUID = -4901434558868605358L;

    public Result result;

    public AppGlobalException(Result result) {
        this.result = result;
    }

    public AppGlobalException(Result result, Object... args) {
        String msg = result.getMsg();
        this.result = result;
        this.result.setMsg(String.format(msg, args));
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
