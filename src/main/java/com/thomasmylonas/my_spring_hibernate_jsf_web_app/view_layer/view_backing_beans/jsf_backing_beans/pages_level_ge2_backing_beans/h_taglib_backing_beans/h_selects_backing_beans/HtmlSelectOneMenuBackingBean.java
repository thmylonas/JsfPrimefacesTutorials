package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectOneBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlSelectOneMenuBackingBean")
public class HtmlSelectOneMenuBackingBean extends AbstractHtmlSelectOneBackingBean {

    private List<ComponentsAttribute> selectOneMenuAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
        initExamplesValues();
        initSelectItemsWithMapsAndArrays();
    }

    private void initComponentsAttributesList() {

        selectOneMenuAttributesList = new ArrayList<>();

        // The common "SelectOne"/"SelectMany" Components' attributes
        selectOneMenuAttributesList.addAll(commonHtmlAttributesService.getCommonSelectsAttributesList());

        selectOneMenuAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }

    public List<ComponentsAttribute> getSelectOneMenuAttributesList() {
        return selectOneMenuAttributesList;
    }
}
