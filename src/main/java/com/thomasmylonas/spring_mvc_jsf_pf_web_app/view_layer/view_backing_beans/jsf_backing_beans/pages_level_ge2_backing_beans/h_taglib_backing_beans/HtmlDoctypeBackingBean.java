package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlDoctypeBackingBean")
public class HtmlDoctypeBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> doctypeAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"styleClass"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        doctypeAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "converter", "binding")
        doctypeAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        doctypeAttributesList.add(new ComponentsAttribute("public", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Will be output as the public part of the DOCTYPE"));
        doctypeAttributesList.add(new ComponentsAttribute("rootElement", true, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The root XML element"));
        doctypeAttributesList.add(new ComponentsAttribute("system", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Will be output as the system part of the DOCTYPE"));
    }

    public List<ComponentsAttribute> getDoctypeAttributesList() {
        return doctypeAttributesList;
    }
}
