package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlInputTextBackingBean")
@ViewScoped
@Getter
@Setter
public class HtmlInputTextBackingBean extends AbstractHtmlInputsBackingBean {

    private List<ComponentsAttribute> inputTextAttributes;

    private HtmlInputText htmlInputText;
    private boolean rendered = true;

    @PostConstruct
    private void init() {
        initCommonHtmlInputsAttributes();
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        htmlInputText = new HtmlInputText();
        inputTextAttributes = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlUiInputsBackingBean"
        inputTextAttributes.addAll(uiInputsAttributes);
    }

    public String hideDisplayInputText() {

        System.out.println("The BackingBean method from 'action' attribute is invoked");
//        String value = (String) htmlInputText.getValue();
//        System.out.println(value);

//        htmlInputText.setValue("QWERTY");
        rendered = !rendered;
        System.out.println(rendered);
//        return "WEB-INF/views/pages_level_2/jsf/jsf_h_taglib/jsf_h_input_text.xhtml";
        return null;
    }
}
