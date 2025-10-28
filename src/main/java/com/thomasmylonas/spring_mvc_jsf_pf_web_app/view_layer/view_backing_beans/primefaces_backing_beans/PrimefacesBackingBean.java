package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.primefaces_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.primefaces_backing_beans._base.AbstractPrimefacesBackingBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "primefacesBackingBean")
public class PrimefacesBackingBean extends AbstractPrimefacesBackingBean {

    @PostConstruct
    private void init() {
    }
}
