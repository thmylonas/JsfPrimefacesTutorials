package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlInputFileBackingBean")
@Getter
public class HtmlInputFileBackingBean extends AbstractHtmlInputsBackingBean {

    private List<ComponentsAttribute> inputFileAttributes;

    @PostConstruct
    private void init() {
        initCommonHtmlInputsAttributes();
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        inputFileAttributes = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlUiInputsBackingBean"
        inputFileAttributes.addAll(uiInputsAttributes);
    }
}
