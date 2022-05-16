package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.CommonHtmlAttributesService;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.JsfBackingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(value = "htmlTaglibBackingBean")
public class HtmlTaglibBackingBean extends JsfBackingBean {

    @Autowired
    protected CommonHtmlAttributesService commonHtmlAttributesService;

    @PostConstruct
    private void init() {
    }

    public CommonHtmlAttributesService getCommonHtmlAttributesService() {
        return commonHtmlAttributesService;
    }
}
