package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlFormBackingBean")
public class HtmlFormBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> formAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        formAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding")
        formAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        formAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));
        formAttributesList.add(new ComponentsAttribute("onsubmit", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when this form is submitted"));
        formAttributesList.add(new ComponentsAttribute("onreset", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when this form is reset"));

        // The most common Components' attributes
        formAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        formAttributesList.add(new ComponentsAttribute("prependId", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether or not this form should prepend its id to its descendent's id during the clientId generation process. If this flag is not set, the default value is true"));
        formAttributesList.add(new ComponentsAttribute("accept", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "List of content types that a server processing this form will handle correctly"));
        formAttributesList.add(new ComponentsAttribute("acceptcharset", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "List of character encodings for input data that are accepted by the server processing this form"));
        formAttributesList.add(new ComponentsAttribute("enctype", false, "application/x-www-form-urlencoded", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Content type used to submit the form to the server. If not specified, the default value is 'application/x-www-form-urlencoded'"));
        formAttributesList.add(new ComponentsAttribute("target", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Name of a frame where the response retrieved after this form submit is to be displayed"));
    }

    public List<ComponentsAttribute> getFormAttributesList() {
        return formAttributesList;
    }
}
