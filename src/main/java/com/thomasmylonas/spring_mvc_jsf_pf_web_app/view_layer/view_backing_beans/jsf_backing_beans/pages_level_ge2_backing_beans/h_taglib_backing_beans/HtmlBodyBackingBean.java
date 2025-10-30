package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlBodyBackingBean")
@Getter
public class HtmlBodyBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "rendered", "converter"};
    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    private List<ComponentsAttribute> bodyAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        bodyAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "styleClass", "binding")
        bodyAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        bodyAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));
        bodyAttributesList.add(new ComponentsAttribute("onload", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when the user agent finishes loading a window or all frames within a frameset"));
        bodyAttributesList.add(new ComponentsAttribute("onunload", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when the user agent removes a document from a window or frame"));

        // The most common Components' attributes
        bodyAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        bodyAttributesList.add(new ComponentsAttribute("xmlns", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "An XML Namespace to be passed through to the rendered element"));
    }
}
