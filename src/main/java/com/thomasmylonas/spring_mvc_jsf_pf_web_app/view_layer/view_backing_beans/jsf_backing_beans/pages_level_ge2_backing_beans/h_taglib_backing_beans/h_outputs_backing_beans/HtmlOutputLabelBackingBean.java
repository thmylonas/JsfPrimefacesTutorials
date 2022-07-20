package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlOutputLabelBackingBean")
public class HtmlOutputLabelBackingBean extends AbstractHtmlOutputsBackingBean {

    private List<ComponentsAttribute> outputLabelAttributesList;

    private final String[] EXCLUDED_INTERACTION_ACCESS_ATTRIBUTES = {"disabled"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    // Text to be used in the 'value' attribute of <h:outputLabel>
    private String outputLabelForWithBackingBean;

    public HtmlOutputLabelBackingBean() {
        outputLabelForWithBackingBean = "'h:outputLabel' using 'for' attribute, with the use of BackingBean:";
    }

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        outputLabelAttributesList = new ArrayList<>();

        // The globally common Components' attributes
        outputLabelAttributesList.addAll(commonHtmlAttributesService.getGloballyCommonAttributesList());

        // The attributes which are handling events
        outputLabelAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        outputLabelAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The attributes of components, with which we can interact
        outputLabelAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonInteractAccessAttributesList(), EXCLUDED_INTERACTION_ACCESS_ATTRIBUTES));

        outputLabelAttributesList.add(new ComponentsAttribute("for", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Search expression to the component for which this element is a label"));
        outputLabelAttributesList.add(new ComponentsAttribute("escape", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that characters that are sensitive in HTML and XML markup must be escaped. If omitted, this flag is assumed to be 'true'"));
    }

    public List<ComponentsAttribute> getOutputLabelAttributesList() {
        return outputLabelAttributesList;
    }

    public String getOutputLabelForWithBackingBean() {
        return outputLabelForWithBackingBean;
    }
}
