package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.CommonHtmlAttributesService;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.JsfBackingBean;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean(name = "htmlTaglibBackingBean")
@Getter
@Setter
public class HtmlTaglibBackingBean extends JsfBackingBean {

    @ManagedProperty(value = "#{commonHtmlAttributesService}")
    protected CommonHtmlAttributesService commonHtmlAttributesService;
}
