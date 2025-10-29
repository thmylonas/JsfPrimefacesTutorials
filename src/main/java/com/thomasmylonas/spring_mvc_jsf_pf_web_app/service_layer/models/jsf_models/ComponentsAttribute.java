package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ComponentsAttribute extends AbstractModel {

    private String name;
    private boolean required;
    private String defaultValue;
    private String type;
    private String description;
}
