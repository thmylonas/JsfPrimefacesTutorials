package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions;

/**
 * This Exception is thrown in case that anything fails while transaction happens
 */
public class GeneralRollbackException extends RuntimeException {

    public GeneralRollbackException(String message, Exception cause) {
        super(message, cause);
    }
}
