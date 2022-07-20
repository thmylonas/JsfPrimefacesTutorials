package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base.AbstractModel;

public class ComponentsAttribute extends AbstractModel {

    private String name;
    private boolean required;
    private String defaultValue;
    private String type;
    private String description;

    public ComponentsAttribute(String name, boolean required, String defaultValue, String type, String description) {
        this.name = name;
        this.required = required;
        this.defaultValue = defaultValue;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
