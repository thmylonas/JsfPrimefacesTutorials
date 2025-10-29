package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlOutputLinkBackingBean")
@Getter
public class HtmlOutputLinkBackingBean extends AbstractHtmlOutputsBackingBean {

    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    private List<ComponentsAttribute> outputLinkAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        outputLinkAttributesList = new ArrayList<>();

        // The globally common Components' attributes
        outputLinkAttributesList.addAll(commonHtmlAttributesService.initAndGetGloballyCommonAttributesList());

        // The attributes which are handling events
        outputLinkAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        outputLinkAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The common "Links" Components' attributes (Alternative attributes: "disabled")
        outputLinkAttributesList.addAll(commonHtmlAttributesService.getCommonLinksAttributesList());
    }
}
