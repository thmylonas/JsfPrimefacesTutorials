package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectManyBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlSelectManyListboxBackingBean")
public class HtmlSelectManyListboxBackingBean extends AbstractHtmlSelectManyBackingBean {

    private List<ComponentsAttribute> selectManyListboxAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
        initExamplesValues();
        initSelectItemsWithMapsAndArrays();
    }

    private void initComponentsAttributesList() {

        selectManyListboxAttributesList = new ArrayList<>();

        // The common "SelectOne"/"SelectMany" Components' attributes
        selectManyListboxAttributesList.addAll(commonHtmlAttributesService.getCommonSelectsAttributesList());

        selectManyListboxAttributesList.add(new ComponentsAttribute("collectionType", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Optional attribute that is a literal string that is the fully qualified class name of a concrete class that implements java.util.Collection, or an EL expression that evaluates to either 1. such a String, or 2. the Class object itself"));
        selectManyListboxAttributesList.add(new ComponentsAttribute("size", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Number of available options to be shown at all times. If not specified, all available options are shown"));
        selectManyListboxAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }

    public List<ComponentsAttribute> getSelectManyListboxAttributesList() {
        return selectManyListboxAttributesList;
    }
}
