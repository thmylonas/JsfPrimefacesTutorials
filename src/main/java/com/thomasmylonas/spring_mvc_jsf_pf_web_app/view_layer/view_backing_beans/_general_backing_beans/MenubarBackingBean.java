package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._general_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models.menubar_models.MainMenubarModel;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;

//@ManagedBean(name = "menubarBackingBean")
@Deprecated
public class MenubarBackingBean extends AbstractBackingBean {

    //@ManagedProperty(value = "#{mainMenubarModel}")
    private MainMenubarModel mainMenubarModel;

    public MainMenubarModel getMainMenubarModel() {
        return mainMenubarModel;
    }
}
