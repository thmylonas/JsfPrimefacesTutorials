package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlLinkBackingBean")
@Getter
public class HtmlLinkBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};
    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    private List<ComponentsAttribute> linkAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        linkAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        linkAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        linkAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        linkAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        // The common "Links" Components' attributes (Alternative attributes: "disabled")
        linkAttributes.addAll(commonHtmlAttributesService.getCommonLinksAttributes());

        // The common "UIOutcomeTarget" Components' attributes
        linkAttributes.addAll(commonHtmlAttributesService.getCommonOutcomeTargetsAttributes());
    }
}
