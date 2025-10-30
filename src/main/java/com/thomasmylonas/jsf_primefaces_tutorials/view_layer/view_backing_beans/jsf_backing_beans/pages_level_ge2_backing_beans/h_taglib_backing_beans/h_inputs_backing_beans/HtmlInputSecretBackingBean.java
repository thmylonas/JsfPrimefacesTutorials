package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlInputSecretBackingBean")
@Getter
public class HtmlInputSecretBackingBean extends AbstractHtmlInputsBackingBean {

    private List<ComponentsAttribute> inputSecretAttributes;

    @PostConstruct
    private void init() {
        initCommonHtmlInputsAttributes();
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        inputSecretAttributes = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlUiInputsBackingBean"
        inputSecretAttributes.addAll(uiInputsAttributes);

        inputSecretAttributes.add(new ComponentsAttribute("redisplay", false, "false", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that any existing value in this field should be rendered when the form is created. Because this is a potential security risk, password values are not displayed by default"));
    }
}
