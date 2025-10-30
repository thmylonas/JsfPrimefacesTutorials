package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlOutputLinkBackingBean")
@Getter
public class HtmlOutputLinkBackingBean extends AbstractHtmlOutputsBackingBean {

    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    private List<ComponentsAttribute> outputLinkAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        outputLinkAttributes = new ArrayList<>();

        // The globally common Components' attributes
        outputLinkAttributes.addAll(commonHtmlAttributesService.initAndGetGloballyCommonAttributes());

        // The attributes which are handling events
        outputLinkAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        outputLinkAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        // The common "Links" Components' attributes (Alternative attributes: "disabled")
        outputLinkAttributes.addAll(commonHtmlAttributesService.getCommonLinksAttributes());
    }
}
