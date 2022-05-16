package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectOneBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlSelectOneListboxBackingBean")
public class HtmlSelectOneListboxBackingBean extends AbstractHtmlSelectOneBackingBean {

    private List<ComponentsAttribute> selectOneListboxAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
        initExamplesValues();
        initSelectItemsWithMapsAndArrays();
    }

    private void initComponentsAttributesList() {

        selectOneListboxAttributesList = new ArrayList<>();

        // The common "SelectOne"/"SelectMany" Components' attributes
        selectOneListboxAttributesList.addAll(commonHtmlAttributesService.getCommonSelectsAttributesList());

        selectOneListboxAttributesList.add(new ComponentsAttribute("size", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Number of available options to be shown at all times. If not specified, all available options are shown"));
    }

    public List<ComponentsAttribute> getSelectOneListboxAttributesList() {
        return selectOneListboxAttributesList;
    }
}
