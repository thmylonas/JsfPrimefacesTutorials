package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models;

public record JavaFrameworksModel(String id, String javaFramework, String javaEdition)
        implements Comparable<JavaFrameworksModel> {

    @Override
    public int compareTo(JavaFrameworksModel o) {
        return this.id.compareTo(o.id);
    }
}
