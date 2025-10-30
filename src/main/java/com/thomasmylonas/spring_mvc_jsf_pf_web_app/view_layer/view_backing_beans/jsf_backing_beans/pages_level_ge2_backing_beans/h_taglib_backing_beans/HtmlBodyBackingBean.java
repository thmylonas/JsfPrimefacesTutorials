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

    private List<ComponentsAttribute> bodyAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        bodyAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "styleClass", "binding")
        bodyAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        bodyAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));
        bodyAttributes.add(new ComponentsAttribute("onload", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when the user agent finishes loading a window or all frames within a frameset"));
        bodyAttributes.add(new ComponentsAttribute("onunload", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when the user agent removes a document from a window or frame"));

        // The most common Components' attributes
        bodyAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        bodyAttributes.add(new ComponentsAttribute("xmlns", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "An XML Namespace to be passed through to the rendered element"));
    }
}
