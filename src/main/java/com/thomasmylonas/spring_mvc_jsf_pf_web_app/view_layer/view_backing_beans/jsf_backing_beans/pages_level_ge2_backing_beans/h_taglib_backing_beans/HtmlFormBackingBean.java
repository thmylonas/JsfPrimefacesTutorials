package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlFormBackingBean")
@Getter
public class HtmlFormBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};
    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    private List<ComponentsAttribute> formAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        formAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding")
        formAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        formAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));
        formAttributes.add(new ComponentsAttribute("onsubmit", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when this form is submitted"));
        formAttributes.add(new ComponentsAttribute("onreset", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when this form is reset"));

        // The most common Components' attributes
        formAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        formAttributes.add(new ComponentsAttribute("prependId", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether or not this form should prepend its id to its descendent's id during the clientId generation process. If this flag is not set, the default value is true"));
        formAttributes.add(new ComponentsAttribute("accept", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "List of content types that a server processing this form will handle correctly"));
        formAttributes.add(new ComponentsAttribute("acceptcharset", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "List of character encodings for input data that are accepted by the server processing this form"));
        formAttributes.add(new ComponentsAttribute("enctype", false, "application/x-www-form-urlencoded", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Content type used to submit the form to the server. If not specified, the default value is 'application/x-www-form-urlencoded'"));
        formAttributes.add(new ComponentsAttribute("target", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Name of a frame where the response retrieved after this form submit is to be displayed"));
    }
}
