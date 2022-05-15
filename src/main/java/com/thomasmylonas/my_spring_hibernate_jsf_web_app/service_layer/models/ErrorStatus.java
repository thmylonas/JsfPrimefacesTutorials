package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models;

import org.springframework.stereotype.Component;

@Component
public class ErrorStatus {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
