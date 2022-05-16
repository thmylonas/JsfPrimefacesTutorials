package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans._base;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHtmlMessagesBackingBean extends HtmlTaglibBackingBean {

    protected List<ComponentsAttribute> messagesComponentsAttributesList;
    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        messagesComponentsAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding")
        messagesComponentsAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The most common Components' attributes
        messagesComponentsAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The common "Messages" Components' attributes
        messagesComponentsAttributesList.addAll(commonHtmlAttributesService.getCommonMessagesAttributesList());
    }
}
