package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlOutputScriptBackingBean")
public class HtmlOutputScriptBackingBean extends AbstractHtmlOutputsBackingBean {

    private List<ComponentsAttribute> outputScriptAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"styleClass"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        outputScriptAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "converter", "binding")
        outputScriptAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        outputScriptAttributesList.add(new ComponentsAttribute("library", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The libraryName for this resource"));
        outputScriptAttributesList.add(new ComponentsAttribute("name", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The resourceName for this resource. This attribute is required if the script is NOT inline"));
        outputScriptAttributesList.add(new ComponentsAttribute("target", false, "See Description...", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The target area for which this resource will be rendered. For example, target='head' would cause the resource to be rendered within the head element. If no value is specified, the script element is rendered at the same point in the view where the tag is located. Currently supported values for this attribute are 'head', 'body', and 'form'"));
    }

    public List<ComponentsAttribute> getOutputScriptAttributesList() {
        return outputScriptAttributesList;
    }
}
