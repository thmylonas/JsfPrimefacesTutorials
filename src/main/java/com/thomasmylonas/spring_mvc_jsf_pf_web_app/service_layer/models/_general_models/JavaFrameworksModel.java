package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class JavaFrameworksModel extends AbstractModel implements Comparable<JavaFrameworksModel>, Serializable {

    private String id;
    private String javaFramework;
    private String javaEdition;

    @Override
    public int compareTo(JavaFrameworksModel o) {
        return this.id.compareTo(o.id);
    }
}
