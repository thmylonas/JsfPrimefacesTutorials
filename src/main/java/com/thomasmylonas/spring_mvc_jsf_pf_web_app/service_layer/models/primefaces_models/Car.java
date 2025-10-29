package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Car extends AbstractModel implements Serializable {

    private String id;
    private String brand;
    private int year;
    private String color;
    private int price;
    private boolean soldState;
}
