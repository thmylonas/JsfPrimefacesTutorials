package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlOutputTextBackingBean")
public class HtmlOutputTextBackingBean extends AbstractHtmlOutputsBackingBean {

    private List<ComponentsAttribute> outputTextAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        outputTextAttributesList = new ArrayList<>();

        // The globally common Components' attributes
        outputTextAttributesList.addAll(commonHtmlAttributesService.getGloballyCommonAttributesList());

        // The most common Components' attributes
        outputTextAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        outputTextAttributesList.add(new ComponentsAttribute("escape", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that characters that are sensitive in HTML and XML markup must be escaped. This flag is set to 'true' by default"));
    }

    public List<ComponentsAttribute> getOutputTextAttributesList() {
        return outputTextAttributesList;
    }
}
