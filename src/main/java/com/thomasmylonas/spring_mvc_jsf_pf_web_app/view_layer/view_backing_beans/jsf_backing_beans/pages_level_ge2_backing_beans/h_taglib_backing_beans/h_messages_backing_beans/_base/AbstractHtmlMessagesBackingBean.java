package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHtmlMessagesBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};

    protected List<ComponentsAttribute> messagesComponentsAttributesList;

    protected void initCommonHtmlMessagesAttributes() {

        messagesComponentsAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding")
        messagesComponentsAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The most common Components' attributes
        messagesComponentsAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        // The common "Messages" Components' attributes
        messagesComponentsAttributesList.addAll(commonHtmlAttributesService.getCommonMessagesAttributes());
    }
}
