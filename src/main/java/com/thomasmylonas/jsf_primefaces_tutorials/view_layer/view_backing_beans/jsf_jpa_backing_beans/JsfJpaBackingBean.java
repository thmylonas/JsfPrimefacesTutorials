package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_jpa_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services.DbJsfJpaService;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services.InMemoryJsfJpaService;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services._base.AbstractJsfJpaService;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans._base.AbstractBackingBean;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;

@ManagedBean(name = "jsfJpaBackingBean")
@Getter
@Setter
public class JsfJpaBackingBean extends AbstractBackingBean {

    private boolean displayDataForms;

    private AbstractJsfJpaService jsfJpaService;

    @ManagedProperty(value = "#{inMemoryJsfJpaService}")
    private InMemoryJsfJpaService inMemoryJsfJpaService;

    @ManagedProperty(value = "#{dbJsfJpaService}")
    private DbJsfJpaService dbJsfJpaService;

    public String fetchDataSource() {

        if (jsfJpaService == null) {
            return "";
        }

        if (jsfJpaService.getDataSource() == null) {
            return "";
        } else {
            if (jsfJpaService.getDataSource().equalsIgnoreCase("InMemoryDS")) {
                return " (Using an " + highlightingSpan("'In-Memory DataSource'", COLOR_BLUE, "bold") + ")";
            } else if (jsfJpaService.getDataSource().equalsIgnoreCase("DatabaseDS")) {
                return " (Using an " + highlightingSpan("'Database DataSource'", COLOR_BLUE, "bold") + ")";
            } else {
                return "";
            }
        }
    }

    public void selectDatasource() {

        if (jsfJpaService == null) {
            return;
        }

        if (jsfJpaService.getDataSource().equalsIgnoreCase("InMemoryDS")) {
            displayDataForms = true;
            jsfJpaService = inMemoryJsfJpaService;
        } else if (jsfJpaService.getDataSource().equalsIgnoreCase("DatabaseDS")) {
            displayDataForms = true;
            jsfJpaService = dbJsfJpaService;
        } else {
            displayDataForms = false;
        }
    }

    public String displayDataFormsInView() {

        resetFetchByIdForm();
        resetSaveForm();
        resetUpdateForm();
        resetDeleteForm();
        return displayDataForms ? "display_data_forms" : "not_display_data_forms";
    }

    public void resetFetchByIdForm() {

        if (jsfJpaService == null) {
            return;
        }
        jsfJpaService.setStudentsFilteredList(new ArrayList<>());
        jsfJpaService.setStudentId(null);
    }

    public void resetSaveForm() {

        if (jsfJpaService == null) {
            return;
        }
        jsfJpaService.resetStudent(jsfJpaService.getSaveFormStudent());
    }

    public void resetUpdateForm() {

        if (jsfJpaService == null) {
            return;
        }
        jsfJpaService.setUpdateFormStudentId(null);
        jsfJpaService.resetStudent(jsfJpaService.getUpdateFormStudent());
    }

    public void resetDeleteForm() {

        if (jsfJpaService == null) {
            return;
        }
        jsfJpaService.setDeleteFormStudentId(null);
    }
}
