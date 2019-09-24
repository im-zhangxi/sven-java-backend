package com.sven.controller;

import lombok.Data;

import java.util.function.Function;

@Data
public class WebApiResponse<T> {

    public static final int SUCCESS_CODE = 0;
    public static final int ERROR_CODE = 1;

    private int code;
    private String error;
    private T data;
    private String authType;
    private Boolean isNeedRetry;


    public static <T> WebApiResponse<T> success(T data) {
        WebApiResponse<T> response = new WebApiResponse<>();
        response.setCode(SUCCESS_CODE);
        response.setData(data);
        return response;
    }

    public static <T> WebApiResponse<T> error(String errorMessage) {
        return WebApiResponse.error(errorMessage, ERROR_CODE);
    }

    public static <T> WebApiResponse<T> error(String errorMessage, int errorCode) {
        return WebApiResponse.error(errorMessage, errorCode, null);
    }

    public static <T> WebApiResponse<T> error(String errorMessage, Boolean isNeedRetry) {
        return WebApiResponse.error(errorMessage, ERROR_CODE, isNeedRetry);
    }

    public static <T> WebApiResponse<T> error(String errorMessage, int errorCode, Boolean isNeedRetry) {
        WebApiResponse<T> response = new WebApiResponse<>();
        response.setCode(errorCode);
        response.setError(errorMessage);
        response.setIsNeedRetry(isNeedRetry);
        return response;
    }

    public static <T> WebApiResponse<T> asProcess(Procedure<T> procedure) {
        return asProcess(procedure, Exception::toString);
    }

    public static <T> WebApiResponse<T> asProcess(Procedure<T> procedure, Function<Exception, String> exceptionHandler) {
        try {
            return success(procedure.apply());
        } catch (Exception e) {
            return error(exceptionHandler.apply(e));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebApiResponse<?> that = (WebApiResponse<?>) o;

        if (code != that.code) return false;
        if (error != null ? !error.equals(that.error) : that.error != null) return false;
        return data.equals(that.data);

    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + data.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WebApiResponse{" +
                "code=" + code +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }

    @FunctionalInterface
    public interface Procedure<T> {
        T apply() throws Exception;
    }
}
