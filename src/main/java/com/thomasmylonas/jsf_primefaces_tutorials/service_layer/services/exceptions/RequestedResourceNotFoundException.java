package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestedResourceNotFoundException extends RuntimeException {

    public RequestedResourceNotFoundException(String clazz, Long resourceId) {
        super(String.format("%s: The '%s' with the ID '%d' is not found!",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")), clazz, resourceId));
    }
}
