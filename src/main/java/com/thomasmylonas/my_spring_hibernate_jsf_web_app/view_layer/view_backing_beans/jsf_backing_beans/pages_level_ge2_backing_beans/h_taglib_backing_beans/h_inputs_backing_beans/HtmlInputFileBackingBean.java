package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlInputFileBackingBean")
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

    public List<ComponentsAttribute> getInputFileAttributesList() {
        return inputFileAttributesList;
    }
}
