package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlInputTextareaBackingBean")
@Getter
public class HtmlInputTextareaBackingBean extends AbstractHtmlInputsBackingBean {

    private List<ComponentsAttribute> inputTextareaAttributes;

    @PostConstruct
    private void init() {
        initCommonHtmlInputsAttributes();
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        inputTextareaAttributes = new ArrayList<>();

        // The common "UIInput" Components' attributes
        inputTextareaAttributes.addAll(commonHtmlAttributesService.getCommonUiInputsAttributes());

        inputTextareaAttributes.add(new ComponentsAttribute("rows", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of rows to be displayed"));
        inputTextareaAttributes.add(new ComponentsAttribute("cols", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of columns to be displayed"));
        inputTextareaAttributes.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }
}
