package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlCommandButtonBackingBean")
@ViewScoped
@Getter
@Setter
public class HtmlCommandButtonBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};

    private List<ComponentsAttribute> commandButtonAttributes;

    private HtmlInputText htmlInputText;
    private boolean rendered = true;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        htmlInputText = new HtmlInputText();

        commandButtonAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        commandButtonAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        commandButtonAttributes.addAll(commonHtmlAttributesService.getCommonEventHandlerAttributes());

        // The subset of the "UIInput" Components' attributes
        commandButtonAttributes.addAll(commonHtmlAttributesService.getSubsetUiInputsAttributes());

        commandButtonAttributes.add(new ComponentsAttribute("action", false, "No default value", "javax.el.MethodExpression (signature must match java.lang.Object action())", "MethodExpression representing the application action to invoke when this component is activated by the user. The expression must evaluate to a public method that takes no parameters, and returns an Object (the toString() of which is called to derive the logical outcome) which is passed to the NavigationHandler for this application"));
        commandButtonAttributes.add(new ComponentsAttribute("actionListener", false, "No default value", "javax.el.MethodExpression (signature must match void actionListener(javax.faces.event.ActionEvent))", "MethodExpression representing an action listener method that will be notified when this component is activated by the user. The expression must evaluate to a public method that takes an ActionEvent parameter, with a return type of void, or to a public method that takes no arguments with a return type of void. In the latter case, the method has no way of easily knowing where the event came from, but this can be useful in cases where a notification is needed that 'some action happened'"));
        commandButtonAttributes.add(new ComponentsAttribute("type", false, "submit", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Type of button to create. Valid values are 'submit', 'button', and 'reset'. If not specified, or not a valid value, the default value is 'submit'"));
        commandButtonAttributes.add(new ComponentsAttribute("image", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Absolute or relative URL of the image to be displayed for this button. If specified, this 'input' element will be of type 'image'. Otherwise, it will be of the type specified by the 'type' property with a label specified by the 'value' property. Note that if the value of this attribute starts with '/', the rendered value for this attribute will be prefixed with the context-root for this application"));
        commandButtonAttributes.add(new ComponentsAttribute("alt", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Alternate textual description of the element rendered by this component"));
        commandButtonAttributes.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that, if this component is activated by the user, notifications should be delivered to interested listeners and actions immediately (that is, during Apply Request Values phase) rather than waiting until Invoke Application phase"));
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
