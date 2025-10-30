package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlOutputScriptBackingBean")
@Getter
public class HtmlOutputScriptBackingBean extends AbstractHtmlOutputsBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"styleClass"};

    private List<ComponentsAttribute> outputScriptAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        outputScriptAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "converter", "binding")
        outputScriptAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        outputScriptAttributes.add(new ComponentsAttribute("library", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The libraryName for this resource"));
        outputScriptAttributes.add(new ComponentsAttribute("name", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The resourceName for this resource. This attribute is required if the script is NOT inline"));
        outputScriptAttributes.add(new ComponentsAttribute("target", false, "See Description...", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The target area for which this resource will be rendered. For example, target='head' would cause the resource to be rendered within the head element. If no value is specified, the script element is rendered at the same point in the view where the tag is located. Currently supported values for this attribute are 'head', 'body', and 'form'"));
    }
}
