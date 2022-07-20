package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.primefaces_models.menubar_models._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base.AbstractModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;

public abstract class AbstractMenubarModel extends AbstractModel {

    protected DefaultMenuItem buildDefaultMenuItem(String value, String icon) {
        return DefaultMenuItem.builder().value(value).icon(icon).build();
    }

    protected DefaultMenuItem buildDefaultMenuItem(String value, String icon, String url) {
        return DefaultMenuItem.builder().value(value).icon(icon).url(url).build();
    }

    protected DefaultSubMenu buildDefaultSubMenu(String label) {
        return DefaultSubMenu.builder().label(label).build();
    }

    protected DefaultSubMenu buildDefaultSubMenu(String label, String icon) {
        return DefaultSubMenu.builder().label(label).icon(icon).build();
    }
}
