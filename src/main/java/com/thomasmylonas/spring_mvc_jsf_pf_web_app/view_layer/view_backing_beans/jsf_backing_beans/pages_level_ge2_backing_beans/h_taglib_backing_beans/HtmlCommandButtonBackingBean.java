package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import javax.faces.component.html.HtmlInputText;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlCommandButtonBackingBean")
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HtmlCommandButtonBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> commandButtonAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};

    private HtmlInputText htmlInputText = new HtmlInputText();
    private boolean rendered = true;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        commandButtonAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        commandButtonAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        commandButtonAttributesList.addAll(commonHtmlAttributesService.getCommonEventHandlerAttributesList());

        // The subset of the "UIInput" Components' attributes
        commandButtonAttributesList.addAll(commonHtmlAttributesService.getSubsetUiInputsAttributesList());

        commandButtonAttributesList.add(new ComponentsAttribute("action", false, "No default value", "javax.el.MethodExpression (signature must match java.lang.Object action())", "MethodExpression representing the application action to invoke when this component is activated by the user. The expression must evaluate to a public method that takes no parameters, and returns an Object (the toString() of which is called to derive the logical outcome) which is passed to the NavigationHandler for this application"));
        commandButtonAttributesList.add(new ComponentsAttribute("actionListener", false, "No default value", "javax.el.MethodExpression (signature must match void actionListener(javax.faces.event.ActionEvent))", "MethodExpression representing an action listener method that will be notified when this component is activated by the user. The expression must evaluate to a public method that takes an ActionEvent parameter, with a return type of void, or to a public method that takes no arguments with a return type of void. In the latter case, the method has no way of easily knowing where the event came from, but this can be useful in cases where a notification is needed that 'some action happened'"));
        commandButtonAttributesList.add(new ComponentsAttribute("type", false, "submit", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Type of button to create. Valid values are 'submit', 'button', and 'reset'. If not specified, or not a valid value, the default value is 'submit'"));
        commandButtonAttributesList.add(new ComponentsAttribute("image", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Absolute or relative URL of the image to be displayed for this button. If specified, this 'input' element will be of type 'image'. Otherwise, it will be of the type specified by the 'type' property with a label specified by the 'value' property. Note that if the value of this attribute starts with '/', the rendered value for this attribute will be prefixed with the context-root for this application"));
        commandButtonAttributesList.add(new ComponentsAttribute("alt", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Alternate textual description of the element rendered by this component"));
        commandButtonAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that, if this component is activated by the user, notifications should be delivered to interested listeners and actions immediately (that is, during Apply Request Values phase) rather than waiting until Invoke Application phase"));
    }

    public List<ComponentsAttribute> getCommandButtonAttributesList() {
        return commandButtonAttributesList;
    }

    public HtmlInputText getHtmlInputText() {
        return htmlInputText;
    }

    public void setHtmlInputText(HtmlInputText htmlInputText) {
        this.htmlInputText = htmlInputText;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void hideDisplayInputText() {

        System.out.println("The BackingBean method from 'action' attribute is invoked");
//        String value = (String) htmlInputText.getValue();
//        System.out.println(value);

//        htmlInputText.setValue("QWERTY");
        rendered = !rendered;
        System.out.println(rendered);
    }
}
