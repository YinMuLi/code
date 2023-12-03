package com.lhc.utils;

import lombok.Getter;

@Getter()
public class ServiceException extends RuntimeException {
    private final int code;

    public ServiceException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
