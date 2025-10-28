package com.thomasmylonas.spring_mvc_jsf_pf_web_app._alt_copies_not_used;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.CommonHtmlAttributesService;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.JsfBackingBean;

import java.io.Serializable;

//@ManagedBean(name = "newNameManagedBean")
//@RequestScoped //@javax.faces.bean.ViewScoped, @javax.faces.view.ViewScoped, @SessionScoped
public class _ExampleManagedBean implements Serializable {

    //@ManagedProperty(value = "#{commonHtmlAttributesService}")
    private CommonHtmlAttributesService commonHtmlAttributesService;
    //@ManagedProperty(value = "#{jsfBackingBean}")
    private JsfBackingBean jsfBackingBean;

    //@PostConstruct
    private void init() {
        // Initialization code
    }

    // In ManagedBeans the ManagedProperties have to have Getters-Setters (mandatory)
}
