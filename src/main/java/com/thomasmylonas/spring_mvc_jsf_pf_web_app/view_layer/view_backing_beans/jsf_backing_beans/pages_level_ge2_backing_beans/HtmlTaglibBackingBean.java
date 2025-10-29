package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.CommonHtmlAttributesService;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.JsfBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "htmlTaglibBackingBean")
@Getter
public class HtmlTaglibBackingBean extends JsfBackingBean {

    @ManagedProperty(value = "#{commonHtmlAttributesService}")
    protected CommonHtmlAttributesService commonHtmlAttributesService;

    @PostConstruct
    private void init() {
    }
}
