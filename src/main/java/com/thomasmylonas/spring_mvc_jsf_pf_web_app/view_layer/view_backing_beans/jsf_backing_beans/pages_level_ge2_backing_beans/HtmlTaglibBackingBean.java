package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.CommonHtmlAttributesService;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.JsfBackingBean;

import javax.annotation.PostConstruct;

//@Component(value = "htmlTaglibBackingBean")
public class HtmlTaglibBackingBean extends JsfBackingBean {

//    @Autowired
    protected CommonHtmlAttributesService commonHtmlAttributesService;

    @PostConstruct
    private void init() {
    }

    public CommonHtmlAttributesService getCommonHtmlAttributesService() {
        return commonHtmlAttributesService;
    }
}
