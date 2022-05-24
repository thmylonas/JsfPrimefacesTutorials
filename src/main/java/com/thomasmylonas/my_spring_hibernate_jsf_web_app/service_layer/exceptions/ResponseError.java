package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions;

public class ResponseError {

    private final String message;
    private final int code;
    private final String exceptionName;
    private final Exception exception;

    public ResponseError(String message, int code, String exceptionName, Exception exception) {
        this.message = message;
        this.code = code;
        this.exceptionName = exceptionName;
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public Exception getException() {
        return exception;
    }
}
