package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.primefaces_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.primefaces_backing_beans._base.AbstractPrimefacesBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(value = "primefacesBackingBean")
public class PrimefacesBackingBean extends AbstractPrimefacesBackingBean {

    @PostConstruct
    private void init() {
    }
}
