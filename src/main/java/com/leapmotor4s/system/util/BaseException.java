package com.leapmotor4s.system.util;

public class BaseException extends RuntimeException {

    private final String errorCode;

    public BaseException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}