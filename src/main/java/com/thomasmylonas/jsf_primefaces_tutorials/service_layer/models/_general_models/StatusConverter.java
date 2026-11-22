package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models._general_models;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.enums.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String statusValue) {
        return Status.valueOfStatus(statusValue);
    }
}
