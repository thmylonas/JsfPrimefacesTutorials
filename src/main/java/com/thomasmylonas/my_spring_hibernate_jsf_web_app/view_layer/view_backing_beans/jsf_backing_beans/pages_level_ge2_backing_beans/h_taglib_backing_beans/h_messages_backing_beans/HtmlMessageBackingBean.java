package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans._base.AbstractHtmlMessagesBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlMessageBackingBean")
public class HtmlMessageBackingBean extends AbstractHtmlMessagesBackingBean {

    private List<ComponentsAttribute> messageAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        messageAttributesList = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlMessagesBackingBean"
        messageAttributesList.addAll(messagesComponentsAttributesList);

        messageAttributesList.add(new ComponentsAttribute("for", true, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Search expression to the component for which to display messages"));
        messageAttributesList.add(new ComponentsAttribute("showDetail", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether the detail portion of displayed messages should be included. Default value is 'true'"));
        messageAttributesList.add(new ComponentsAttribute("showSummary", false, "false", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether the summary portion of displayed messages should be included. Default value is 'false'"));
    }

    public List<ComponentsAttribute> getMessageAttributesList() {
        return messageAttributesList;
    }
}
