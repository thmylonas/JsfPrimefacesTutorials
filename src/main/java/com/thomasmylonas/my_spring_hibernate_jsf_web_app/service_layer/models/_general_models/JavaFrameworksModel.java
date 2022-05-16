package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models._general_models;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models._base.AbstractModel;

import java.io.Serializable;

public class JavaFrameworksModel extends AbstractModel implements Comparable<JavaFrameworksModel>, Serializable {

    private String id;
    private String javaFramework;
    private String javaEdition;

    public JavaFrameworksModel(String id, String javaFramework, String javaEdition) {
        this.id = id;
        this.javaFramework = javaFramework;
        this.javaEdition = javaEdition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJavaFramework() {
        return javaFramework;
    }

    public void setJavaFramework(String javaFramework) {
        this.javaFramework = javaFramework;
    }

    public String getJavaEdition() {
        return javaEdition;
    }

    public void setJavaEdition(String javaEdition) {
        this.javaEdition = javaEdition;
    }

    @Override
    public int compareTo(JavaFrameworksModel o) {
        return this.id.compareTo(o.id);
    }
}
