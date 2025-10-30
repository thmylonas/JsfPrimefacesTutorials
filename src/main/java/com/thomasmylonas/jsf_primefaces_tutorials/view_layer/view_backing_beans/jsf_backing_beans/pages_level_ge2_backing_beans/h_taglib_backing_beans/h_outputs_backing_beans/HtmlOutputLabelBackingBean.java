package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlOutputLabelBackingBean")
@Getter
public class HtmlOutputLabelBackingBean extends AbstractHtmlOutputsBackingBean {

    private static final String[] EXCLUDED_INTERACTION_ACCESS_ATTRIBUTES = {"disabled"};
    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    private List<ComponentsAttribute> outputLabelAttributes;

    // Text to be used in the 'value' attribute of <h:outputLabel>
    private final String outputLabelForWithBackingBean;

    public HtmlOutputLabelBackingBean() {
        outputLabelForWithBackingBean = "'h:outputLabel' using 'for' attribute, with the use of BackingBean:";
    }

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        outputLabelAttributes = new ArrayList<>();

        // The globally common Components' attributes
        outputLabelAttributes.addAll(commonHtmlAttributesService.initAndGetGloballyCommonAttributes());

        // The attributes which are handling events
        outputLabelAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        outputLabelAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        // The attributes of components, with which we can interact
        outputLabelAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetCommonInteractAccessAttributes(), EXCLUDED_INTERACTION_ACCESS_ATTRIBUTES));

        outputLabelAttributes.add(new ComponentsAttribute("for", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Search expression to the component for which this element is a label"));
        outputLabelAttributes.add(new ComponentsAttribute("escape", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that characters that are sensitive in HTML and XML markup must be escaped. If omitted, this flag is assumed to be 'true'"));
    }
}
