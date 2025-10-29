package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlInputFileBackingBean")
@Getter
public class HtmlInputFileBackingBean extends AbstractHtmlInputsBackingBean {

    private List<ComponentsAttribute> inputFileAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        inputFileAttributesList = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlUiInputsBackingBean"
        inputFileAttributesList.addAll(uiInputsAttributesList);
    }
}
