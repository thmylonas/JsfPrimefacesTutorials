package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHtmlInputsBackingBean extends HtmlTaglibBackingBean {

    protected List<ComponentsAttribute> uiInputsAttributes;

    protected void initCommonHtmlInputsAttributes() {

        uiInputsAttributes = new ArrayList<>();

        // The common "UIInput" Components' attributes
        uiInputsAttributes.addAll(commonHtmlAttributesService.getCommonUiInputsAttributes());

        uiInputsAttributes.add(new ComponentsAttribute("alt", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Alternate textual description of the element rendered by this component"));
        uiInputsAttributes.add(new ComponentsAttribute("maxlength", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The maximum number of characters that may be entered in this field"));
        uiInputsAttributes.add(new ComponentsAttribute("size", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of characters used to determine the width of this field"));
        uiInputsAttributes.add(new ComponentsAttribute("autocomplete", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "If the value of this attribute is 'off', render 'off' as the value of the attribute. This indicates that the browser should disable its autocomplete feature for this component. This is useful for components that perform autocompletion and do not want the browser interfering. If this attribute is not set or the value is 'on', render nothing"));
        uiInputsAttributes.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }
}
