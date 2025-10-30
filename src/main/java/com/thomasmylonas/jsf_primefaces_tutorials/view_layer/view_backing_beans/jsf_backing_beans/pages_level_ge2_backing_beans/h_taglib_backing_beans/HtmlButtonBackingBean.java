package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlButtonBackingBean")
@Getter
public class HtmlButtonBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};
    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    private List<ComponentsAttribute> buttonAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        buttonAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        buttonAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        buttonAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        buttonAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        // The attributes of components, with which we can interact
        buttonAttributes.addAll(commonHtmlAttributesService.initAndGetCommonInteractAccessAttributes());

        // The common "UIOutcomeTarget" Components' attributes
        buttonAttributes.addAll(commonHtmlAttributesService.getCommonOutcomeTargetsAttributes());

        buttonAttributes.add(new ComponentsAttribute("alt", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Alternate textual description of the element rendered by this component"));
        buttonAttributes.add(new ComponentsAttribute("image", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Absolute or relative URL of the image to be displayed for this button. If specified, this 'input' element will be of type 'image'. Otherwise, it will be of the type specified by the 'type' property with a label specified by the 'value' property. Note that if the value of this attribute starts with '/', the rendered value for this attribute will be prefixed with the context-root for this application"));
    }
}
