package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlOutputLinkBackingBean")
public class HtmlOutputLinkBackingBean extends AbstractHtmlOutputsBackingBean {

    private List<ComponentsAttribute> outputLinkAttributesList;

    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        outputLinkAttributesList = new ArrayList<>();

        // The globally common Components' attributes
        outputLinkAttributesList.addAll(commonHtmlAttributesService.getGloballyCommonAttributesList());

        // The attributes which are handling events
        outputLinkAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        outputLinkAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The common "Links" Components' attributes (Alternative attributes: "disabled")
        outputLinkAttributesList.addAll(commonHtmlAttributesService.getCommonLinksAttributesList());
    }

    public List<ComponentsAttribute> getOutputLinkAttributesList() {
        return outputLinkAttributesList;
    }
}
