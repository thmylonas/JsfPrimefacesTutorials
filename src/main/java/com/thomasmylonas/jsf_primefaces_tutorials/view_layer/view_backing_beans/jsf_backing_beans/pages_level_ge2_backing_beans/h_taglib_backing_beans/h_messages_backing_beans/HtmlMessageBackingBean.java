package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans._base.AbstractHtmlMessagesBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlMessageBackingBean")
@Getter
public class HtmlMessageBackingBean extends AbstractHtmlMessagesBackingBean {

    private List<ComponentsAttribute> messageAttributes;

    @PostConstruct
    private void init() {
        initCommonHtmlMessagesAttributes();
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        messageAttributes = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlMessagesBackingBean"
        messageAttributes.addAll(messagesComponentsAttributes);

        messageAttributes.add(new ComponentsAttribute("for", true, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Search expression to the component for which to display messages"));
        messageAttributes.add(new ComponentsAttribute("showDetail", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether the detail portion of displayed messages should be included. Default value is 'true'"));
        messageAttributes.add(new ComponentsAttribute("showSummary", false, "false", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether the summary portion of displayed messages should be included. Default value is 'false'"));
    }
}
