package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlInputSecretBackingBean")
public class HtmlInputSecretBackingBean extends AbstractHtmlInputsBackingBean {

    private List<ComponentsAttribute> inputSecretAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        inputSecretAttributesList = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlUiInputsBackingBean"
        inputSecretAttributesList.addAll(uiInputsAttributesList);

        inputSecretAttributesList.add(new ComponentsAttribute("redisplay", false, "false", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that any existing value in this field should be rendered when the form is created. Because this is a potential security risk, password values are not displayed by default"));
    }

    public List<ComponentsAttribute> getInputSecretAttributesList() {
        return inputSecretAttributesList;
    }
}
