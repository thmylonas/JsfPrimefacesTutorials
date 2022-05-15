package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models;

public class MyError extends Error {

    private int code;
    private String message;

    public MyError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
