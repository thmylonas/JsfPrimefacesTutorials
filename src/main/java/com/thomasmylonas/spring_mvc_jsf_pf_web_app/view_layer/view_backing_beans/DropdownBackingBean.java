package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//@ManagedBean(name = "dropdownBackingBean")
@Getter
@Deprecated
public class DropdownBackingBean implements Serializable {

    private final Map<String, Map<String, String>> data = new HashMap<>();

    @Setter
    private String country;

    @Setter
    private String city;

    private Map<String, String> countries;
    private Map<String, String> cities;

    @PostConstruct
    public void init() {

        countries = new HashMap<>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");

        Map<String, String> map = new HashMap<>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);

        map = new HashMap<>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);

        map = new HashMap<>();
        map.put("Sao Paulo", "Sao Paulo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }

    public void onCountryChange() {

        if (country != null && !country.isEmpty()) {
            cities = data.get(country);
        } else {
            cities = new HashMap<>();
        }
    }

    public void displayLocation() {

        FacesMessage msg;
        if (city != null && country != null) {
            msg = new FacesMessage("Selected", city + " of " + country);
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
