package com.echo.mall.api;

public enum ResultEnum implements IErrorCode {
    SUCCESS(0000, "成功"),

    SERVER_ERROR(9999, "服务器错误");

    private final long code;

    private final String message;

    ResultEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
