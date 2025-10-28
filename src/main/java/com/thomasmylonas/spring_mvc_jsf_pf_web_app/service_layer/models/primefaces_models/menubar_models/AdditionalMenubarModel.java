package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models.menubar_models;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models.menubar_models._base.AbstractMenubarModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

//@ManagedBean(name = "additionalMenubarModel")
@Deprecated
public class AdditionalMenubarModel extends AbstractMenubarModel {

    private final MenuModel additionalMenuModel = new DefaultMenuModel();

    //@PostConstruct
    private void init() {

        // First submenu
        DefaultSubMenu firstSubmenu = buildDefaultSubMenu("Dynamic Submenu");

        DefaultMenuItem item = buildDefaultMenuItem("External", "pi pi-home", "https://www.primefaces.org");
        firstSubmenu.getElements().add(item);

        additionalMenuModel.getElements().add(firstSubmenu);

        // Second submenu
        DefaultSubMenu secondSubmenu = buildDefaultSubMenu("Dynamic Actions");

        item = buildDefaultMenuItem("Save", "pi pi-save");
        item.setCommand("#{menuView.save}");
        item.setUpdate("messages");
        secondSubmenu.getElements().add(item);

        item = buildDefaultMenuItem("Delete", "pi pi-times");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.getElements().add(item);

        item = buildDefaultMenuItem("Redirect", "pi pi-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.getElements().add(item);

        item = buildDefaultMenuItem("Pencil", "ui-icon-pencil");
        secondSubmenu.getElements().add(item);

        item = buildDefaultMenuItem("Hotels", "fa fa-hotels");
        secondSubmenu.getElements().add(item);

        additionalMenuModel.getElements().add(secondSubmenu);
    }

    @SuppressWarnings("unused")
    public MenuModel getAdditionalMenuModel() {
        return additionalMenuModel;
    }

    @SuppressWarnings("unused")
    public void save() {
        addMessage("Success on save", "Data saved");
    }

    @SuppressWarnings("unused")
    public void update() {
        addMessage("Success on update", "Data updated");
    }

    @SuppressWarnings("unused")
    public void delete() {
        addMessage("Success on delete", "Data deleted");
    }

    private void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
