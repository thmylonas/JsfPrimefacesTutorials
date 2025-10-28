package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlLinkBackingBean")
public class HtmlLinkBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> linkAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        linkAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        linkAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        linkAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        linkAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The common "Links" Components' attributes (Alternative attributes: "disabled")
        linkAttributesList.addAll(commonHtmlAttributesService.getCommonLinksAttributesList());

        // The common "UIOutcomeTarget" Components' attributes
        linkAttributesList.addAll(commonHtmlAttributesService.getCommonOutcomeTargetsAttributesList());
    }

    public List<ComponentsAttribute> getLinkAttributesList() {
        return linkAttributesList;
    }
}
