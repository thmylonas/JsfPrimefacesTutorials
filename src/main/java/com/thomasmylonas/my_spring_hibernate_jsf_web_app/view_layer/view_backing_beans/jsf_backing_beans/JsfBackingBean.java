package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans._base.AbstractJsfBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(value = "jsfBackingBean")
public class JsfBackingBean extends AbstractJsfBackingBean {

    @PostConstruct
    private void init() {
    }
}
