package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models._base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JavaFrameworksLabelValueWrapper extends AbstractModel {

    private final String itemLabel;
    private final String itemValue;
}
