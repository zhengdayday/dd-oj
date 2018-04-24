package com.ddoj.web.controller.exception;

/**
 * @author zhengtt
 **/
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("未被授权");
    }

    public UnauthorizedException(String msg) {
        super(msg);
    }
}
