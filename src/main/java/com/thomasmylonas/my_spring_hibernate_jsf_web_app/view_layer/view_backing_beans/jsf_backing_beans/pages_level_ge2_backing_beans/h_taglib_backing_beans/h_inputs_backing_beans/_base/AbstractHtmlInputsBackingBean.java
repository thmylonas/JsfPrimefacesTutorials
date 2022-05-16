package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHtmlInputsBackingBean extends HtmlTaglibBackingBean {

    protected List<ComponentsAttribute> uiInputsAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        uiInputsAttributesList = new ArrayList<>();

        // The common "UIInput" Components' attributes
        uiInputsAttributesList.addAll(commonHtmlAttributesService.getCommonUiInputsAttributesList());

        uiInputsAttributesList.add(new ComponentsAttribute("alt", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Alternate textual description of the element rendered by this component"));
        uiInputsAttributesList.add(new ComponentsAttribute("maxlength", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The maximum number of characters that may be entered in this field"));
        uiInputsAttributesList.add(new ComponentsAttribute("size", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of characters used to determine the width of this field"));
        uiInputsAttributesList.add(new ComponentsAttribute("autocomplete", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "If the value of this attribute is 'off', render 'off' as the value of the attribute. This indicates that the browser should disable its autocomplete feature for this component. This is useful for components that perform autocompletion and do not want the browser interfering. If this attribute is not set or the value is 'on', render nothing"));
        uiInputsAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }
}
