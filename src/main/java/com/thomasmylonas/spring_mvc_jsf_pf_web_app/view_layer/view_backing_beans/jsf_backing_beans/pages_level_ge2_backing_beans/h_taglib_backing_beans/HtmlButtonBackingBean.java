package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlButtonBackingBean")
public class HtmlButtonBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> buttonAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        buttonAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        buttonAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        buttonAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        buttonAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The attributes of components, with which we can interact
        buttonAttributesList.addAll(commonHtmlAttributesService.getCommonInteractAccessAttributesList());

        // The common "UIOutcomeTarget" Components' attributes
        buttonAttributesList.addAll(commonHtmlAttributesService.getCommonOutcomeTargetsAttributesList());

        buttonAttributesList.add(new ComponentsAttribute("alt", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Alternate textual description of the element rendered by this component"));
        buttonAttributesList.add(new ComponentsAttribute("image", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Absolute or relative URL of the image to be displayed for this button. If specified, this 'input' element will be of type 'image'. Otherwise, it will be of the type specified by the 'type' property with a label specified by the 'value' property. Note that if the value of this attribute starts with '/', the rendered value for this attribute will be prefixed with the context-root for this application"));
    }

    public List<ComponentsAttribute> getButtonAttributesList() {
        return buttonAttributesList;
    }
}
