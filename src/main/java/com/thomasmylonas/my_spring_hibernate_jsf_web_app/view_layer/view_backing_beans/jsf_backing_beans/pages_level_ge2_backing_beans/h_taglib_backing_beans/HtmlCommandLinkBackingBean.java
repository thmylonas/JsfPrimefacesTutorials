package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlCommandLinkBackingBean")
public class HtmlCommandLinkBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> commandLinkAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        commandLinkAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        commandLinkAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        commandLinkAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        commandLinkAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The common "Links" Components' attributes (Alternative attributes: "disabled")
        commandLinkAttributesList.addAll(commonHtmlAttributesService.getCommonLinksAttributesList());

        commandLinkAttributesList.add(new ComponentsAttribute("action", false, "No default value", "javax.el.MethodExpression (signature must match java.lang.Object action())", "MethodExpression representing the application action to invoke when this component is activated by the user. The expression must evaluate to a public method that takes no parameters, and returns an Object (the toString() of which is called to derive the logical outcome) which is passed to the NavigationHandler for this application"));
        commandLinkAttributesList.add(new ComponentsAttribute("actionListener", false, "No default value", "javax.el.MethodExpression (signature must match void actionListener(javax.faces.event.ActionEvent))", "MethodExpression representing an action listener method that will be notified when this component is activated by the user. The expression must evaluate to a public method that takes an ActionEvent parameter, with a return type of void, or to a public method that takes no arguments with a return type of void. In the latter case, the method has no way of easily knowing where the event came from, but this can be useful in cases where a notification is needed that 'some action happened'"));
        commandLinkAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that, if this component is activated by the user, notifications should be delivered to interested listeners and actions immediately (that is, during Apply Request Values phase) rather than waiting until Invoke Application phase"));
    }

    public List<ComponentsAttribute> getCommandLinkAttributesList() {
        return commandLinkAttributesList;
    }
}
