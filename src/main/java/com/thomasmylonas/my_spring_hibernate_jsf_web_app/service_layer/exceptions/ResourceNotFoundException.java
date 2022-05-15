package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private long resourceId;
    private String myMessage; // "message" in SuperClass not settable

    public ResourceNotFoundException(long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
        myMessage = message;
    }

    public long getResourceId() {
        return resourceId;
    }

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }
}
