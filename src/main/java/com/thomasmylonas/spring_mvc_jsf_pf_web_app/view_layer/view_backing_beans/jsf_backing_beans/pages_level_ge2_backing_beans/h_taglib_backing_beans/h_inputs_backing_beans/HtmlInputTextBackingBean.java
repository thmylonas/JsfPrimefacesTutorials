package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlInputTextBackingBean")
public class HtmlInputTextBackingBean extends AbstractHtmlInputsBackingBean {

    private List<ComponentsAttribute> inputTextAttributesList;

    private HtmlInputText htmlInputText = new HtmlInputText();
    private boolean rendered = true;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        inputTextAttributesList = new ArrayList<>();

        // These attributes are inherited from the superclass "AbstractHtmlUiInputsBackingBean"
        inputTextAttributesList.addAll(uiInputsAttributesList);
    }

    public List<ComponentsAttribute> getInputTextAttributesList() {
        return inputTextAttributesList;
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
