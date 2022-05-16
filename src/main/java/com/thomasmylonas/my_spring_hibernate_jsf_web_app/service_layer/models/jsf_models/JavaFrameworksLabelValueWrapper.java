package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models._base.AbstractModel;

public class JavaFrameworksLabelValueWrapper extends AbstractModel {

    private final String itemLabel;
    private final String itemValue;

    public JavaFrameworksLabelValueWrapper(String itemLabel, String itemValue) {
        this.itemLabel = itemLabel;
        this.itemValue = itemValue;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public String getItemValue() {
        return itemValue;
    }
}
