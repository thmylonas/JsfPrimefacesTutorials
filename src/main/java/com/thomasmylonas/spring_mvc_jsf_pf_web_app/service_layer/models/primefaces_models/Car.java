package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models;

import lombok.Builder;

@Builder
public record Car(
        String id,
        String brand,
        int year,
        String color,
        int price,
        boolean soldState
) {
}
