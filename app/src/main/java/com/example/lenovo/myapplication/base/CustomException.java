package com.example.lenovo.myapplication.base;

public class CustomException extends Throwable {

    private String errorType;
    private String errorCode;

    public CustomException(String errorType, String errorCode) {
        this.errorType = errorType;
        this.errorCode = errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
