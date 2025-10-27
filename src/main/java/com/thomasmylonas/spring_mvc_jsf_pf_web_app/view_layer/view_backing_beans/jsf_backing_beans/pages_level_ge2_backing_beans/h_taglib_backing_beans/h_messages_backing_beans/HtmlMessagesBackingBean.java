package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_messages_backing_beans._base.AbstractHtmlMessagesBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlMessagesBackingBean")
public class HtmlMessagesBackingBean extends AbstractHtmlMessagesBackingBean {

    private List<ComponentsAttribute> messagesAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        messagesAttributesList = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlMessagesBackingBean"
        messagesAttributesList.addAll(messagesComponentsAttributesList);

        messagesAttributesList.add(new ComponentsAttribute("for", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Search expression to the component for which to display messages. This attribute is mutually exclusive with globalOnly and take precedence if used"));
        messagesAttributesList.add(new ComponentsAttribute("showDetail", false, "false", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether the detail portion of displayed messages should be included. Default value is 'false'"));
        messagesAttributesList.add(new ComponentsAttribute("showSummary", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether the summary portion of displayed messages should be included. Default value is 'true'"));
        messagesAttributesList.add(new ComponentsAttribute("globalOnly", false, "false", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that only global messages (that is, messages not associated with any client identifier) are to be displayed. Default value is 'false'"));
        messagesAttributesList.add(new ComponentsAttribute("layout", false, "list", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The type of layout markup to use when rendering error messages. Valid values are 'table' (an HTML table) and 'list' (an HTML list). If not specified, the default value is 'list'"));
    }

    public List<ComponentsAttribute> getMessagesAttributesList() {
        return messagesAttributesList;
    }
}
