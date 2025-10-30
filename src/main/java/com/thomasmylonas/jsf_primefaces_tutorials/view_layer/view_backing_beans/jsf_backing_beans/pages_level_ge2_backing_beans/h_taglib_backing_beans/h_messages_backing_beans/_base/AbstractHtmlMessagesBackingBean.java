package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans._base;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHtmlMessagesBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};

    protected List<ComponentsAttribute> messagesComponentsAttributes;

    protected void initCommonHtmlMessagesAttributes() {

        messagesComponentsAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding")
        messagesComponentsAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The most common Components' attributes
        messagesComponentsAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        // The common "Messages" Components' attributes
        messagesComponentsAttributes.addAll(commonHtmlAttributesService.getCommonMessagesAttributes());
    }
}
