package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlCommandScriptBackingBean")
public class HtmlCommandScriptBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> commandScriptAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"styleClass", "converter"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        commandScriptAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "binding")
        commandScriptAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        commandScriptAttributesList.add(new ComponentsAttribute("onevent", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The name of the JavaScript function that will handle UI events"));
        commandScriptAttributesList.add(new ComponentsAttribute("onerror", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The name of the JavaScript function that will handle errors"));

        commandScriptAttributesList.add(new ComponentsAttribute("action", false, "No default value", "javax.el.MethodExpression (signature must match java.lang.Object action())", "MethodExpression representing the application action to invoke when this component is activated by the user. The expression must evaluate to a public method that takes no parameters, and returns an Object (the toString() of which is called to derive the logical outcome) which is passed to the NavigationHandler for this application"));
        commandScriptAttributesList.add(new ComponentsAttribute("actionListener", false, "No default value", "javax.el.MethodExpression (signature must match void actionListener(javax.faces.event.ActionEvent))", "MethodExpression representing an action listener method that will be notified when this component is activated by the user. The expression must evaluate to a public method that takes an ActionEvent parameter, with a return type of void, or to a public method that takes no arguments with a return type of void. In the latter case, the method has no way of easily knowing where the event came from, but this can be useful in cases where a notification is needed that 'some action happened'"));
        commandScriptAttributesList.add(new ComponentsAttribute("autorun", false, "false", "javax.el.ValueExpression (must evaluate to boolean)", "Whether to execute declared JavaScript function during load event of the window. Defaults to false"));
        commandScriptAttributesList.add(new ComponentsAttribute("execute", false, "@this", "javax.el.ValueExpression (must evaluate to java.lang.String)", "This is a space separated list of client identifiers of components that will participate in the 'execute' portion of the Request Processing Lifecycle. If a literal is specified the identifiers must be space delimited. Any of the keywords '@this', '@form', '@all', '@none' may be specified in the identifier list. If not specified, the default value of '@this' is assumed. For example, @this clientIdOne clientIdTwo"));
        commandScriptAttributesList.add(new ComponentsAttribute("name", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Name of JavaScript function to be declared, e.g. name='functionName'. This can be a namespaced function name, e.g. name='ez.functionName'"));
        commandScriptAttributesList.add(new ComponentsAttribute("render", false, "@none", "javax.el.ValueExpression (must evaluate to java.lang.String)", "This is a space separated list of client identifiers of components that will participate in the 'render' portion of the Request Processing Lifecycle. If a literal is specified the identifiers must be space delimited. Any of the keywords '@this', '@form', '@all', '@none' may be specified in the identifier list. If not specified, the default value of '@none' is assumed. For example, @this clientIdOne clientIdTwo"));
        commandScriptAttributesList.add(new ComponentsAttribute("resetValues", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.Boolean)", "Reset specific input values. Interpret the value of the render attribute as a space separated list of client identifiers suitable for passing directly to UIViewRoot.resetValues(). The implementation must cause an ActionListener to be attached to the ActionSource component in which this tag is nested that calls UIViewRoot.resetValues() passing the value of the render attribute as the argument"));
        commandScriptAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that, if this component is activated by the user, notifications should be delivered to interested listeners and actions immediately (that is, during Apply Request Values phase) rather than waiting until Invoke Application phase"));
    }

    public List<ComponentsAttribute> getCommandScriptAttributesList() {
        return commandScriptAttributesList;
    }
}
