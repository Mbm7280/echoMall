package com.echo.mall.api;

public class ResObj<T> {

    private long code;
    private String message;
    private T data;

    public ResObj(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public ResObj(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResObj<T> success() {
        return new ResObj<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    public static <T> ResObj<T> success(T data) {
        return new ResObj<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> ResObj<T> success(String message,T data) {
        return new ResObj<T>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> ResObj<T> success(long code,String message,T data) {
        return new ResObj<T>(code, message, data);
    }

    public static <T> ResObj<T> failed() {
        return new ResObj<T>(ResultEnum.SERVER_ERROR.getCode(), ResultEnum.SERVER_ERROR.getMessage(), null);
    }

    public static <T> ResObj<T> failed(T data) {
        return new ResObj<T>(ResultEnum.SERVER_ERROR.getCode(), ResultEnum.SERVER_ERROR.getMessage(), data);
    }

    public static <T> ResObj<T> failed(String message,T data) {
        return new ResObj<T>(ResultEnum.SERVER_ERROR.getCode(), message, data);
    }

    public static <T> ResObj<T> failed(long code, String message,T data) {
        return new ResObj<T>(code, message, data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
