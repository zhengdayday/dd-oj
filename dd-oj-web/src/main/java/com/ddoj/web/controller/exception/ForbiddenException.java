package com.ddoj.web.controller.exception;

/**
 * @author zhengtt
 **/
public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        super("禁止访问");
    }

    public ForbiddenException(String msg) {
        super(msg);
    }
}
