package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.primefaces_models.menubar_models;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.primefaces_models.menubar_models._base.AbstractMenubarModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

//@Component(value = "mainMenubarModel")
public class MainMenubarModel extends AbstractMenubarModel {

    private final MenuModel menuModel = new DefaultMenuModel();

    //@PostConstruct
    private void init() {

        /////////////////////////////////////////////////////////////////////////
        // Item Level 1 - Home
        /////////////////////////////////////////////////////////////////////////

        DefaultMenuItem item = DefaultMenuItem.builder().value("Home").url(WEBAPP_LINK + "facelets/home").build();
        menuModel.getElements().add(item);

        /////////////////////////////////////////////////////////////////////////
        // Item Level 1 - Spring Framework
        /////////////////////////////////////////////////////////////////////////

        item = DefaultMenuItem.builder().value("Spring Framework").url(WEBAPP_LINK + "facelets/spring-framework").build();
        menuModel.getElements().add(item);

        /////////////////////////////////////////////////////////////////////////
        // SubMenu Level 1 - JavaServer Faces
        /////////////////////////////////////////////////////////////////////////

        DefaultSubMenu jsfSubmenu = buildDefaultSubMenu("JavaServer Faces");

        item = buildDefaultMenuItem("JavaServer Faces", "jsf", WEBAPP_LINK + "facelets/jsf");
        jsfSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Primefaces", "primefaces", WEBAPP_LINK + "facelets/primefaces");
        jsfSubmenu.getElements().add(item);

        menuModel.getElements().add(jsfSubmenu);

        /////////////////////////////////////////////////////////////////////////
        // Item Level 1 - About
        /////////////////////////////////////////////////////////////////////////

        item = DefaultMenuItem.builder().value("About").url(WEBAPP_LINK + "facelets/about").build();
        menuModel.getElements().add(item);
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }
}
