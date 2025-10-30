package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlDoctypeBackingBean")
@Getter
public class HtmlDoctypeBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"styleClass"};

    private List<ComponentsAttribute> doctypeAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        doctypeAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "converter", "binding")
        doctypeAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        doctypeAttributes.add(new ComponentsAttribute("public", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Will be output as the public part of the DOCTYPE"));
        doctypeAttributes.add(new ComponentsAttribute("rootElement", true, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The root XML element"));
        doctypeAttributes.add(new ComponentsAttribute("system", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Will be output as the system part of the DOCTYPE"));
    }
}
