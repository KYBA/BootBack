package com.example.demo.common;

public enum ResultCode implements IErrorCode {
    SUCCESS(200, "success"),
    FAILED(500, "failed"),
    VALIDATE_FAILED(404, "Parameter verification failed"),
    UNAUTHORIZED(401, "Not logged in temporarily or the token has expired"),
    FORBIDDEN(403, "No relevant authority");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
