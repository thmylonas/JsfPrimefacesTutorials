package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlInputTextareaBackingBean")
public class HtmlInputTextareaBackingBean extends AbstractHtmlInputsBackingBean {

    private List<ComponentsAttribute> inputTextareaAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        inputTextareaAttributesList = new ArrayList<>();

        // The common "UIInput" Components' attributes
        inputTextareaAttributesList.addAll(commonHtmlAttributesService.getCommonUiInputsAttributesList());

        inputTextareaAttributesList.add(new ComponentsAttribute("rows", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of rows to be displayed"));
        inputTextareaAttributesList.add(new ComponentsAttribute("cols", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of columns to be displayed"));
        inputTextareaAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }

    public List<ComponentsAttribute> getInputTextareaAttributesList() {
        return inputTextareaAttributesList;
    }
}
