package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions;

/**
 * This is the ResourceNotFoundException which carries the "type" (Class) and the "ID" of the resource.
 * In its creation it sets up the super-RuntimeException's message, with the "type" (Class) and the "ID" of the resource
 */
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceClass;
    private final Long resourceId;

    public ResourceNotFoundException(String clazz, Long id) {
        super(String.format("The entity '%s' with ID '%d' is not found!", clazz, id));
        this.resourceClass = clazz;
        this.resourceId = id;
    }

    public String getResourceClass() {
        return resourceClass;
    }

    public Long getResourceId() {
        return resourceId;
    }
}
