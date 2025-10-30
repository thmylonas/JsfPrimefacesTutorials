package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans._general_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.primefaces_models.menubar_models.MainMenubarModel;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans._base.AbstractBackingBean;
import lombok.Getter;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;

//@ManagedBean(name = "menubarBackingBean")
@Getter
@Deprecated
public class MenubarBackingBean extends AbstractBackingBean {

    //@ManagedProperty(value = "#{mainMenubarModel}")
    private MainMenubarModel mainMenubarModel;
}
