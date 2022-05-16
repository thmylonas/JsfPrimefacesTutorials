package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans._general_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.primefaces_models.menubar_models.MainMenubarModel;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;

//@Component(value = "menubarBackingBean")
@SuppressWarnings("unused")
public class MenubarBackingBean extends AbstractBackingBean {

    private final MainMenubarModel mainMenubarModel;

    //@Autowired
    public MenubarBackingBean(MainMenubarModel mainMenubarModel) {
        this.mainMenubarModel = mainMenubarModel;
    }

    @SuppressWarnings("unused")
    public MainMenubarModel getMainMenubarModel() {
        return mainMenubarModel;
    }
}
