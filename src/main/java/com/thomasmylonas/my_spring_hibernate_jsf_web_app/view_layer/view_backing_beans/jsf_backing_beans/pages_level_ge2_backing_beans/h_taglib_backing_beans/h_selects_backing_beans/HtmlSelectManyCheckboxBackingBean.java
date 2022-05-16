package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectManyBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlSelectManyCheckboxBackingBean")
public class HtmlSelectManyCheckboxBackingBean extends AbstractHtmlSelectManyBackingBean {

    private List<ComponentsAttribute> selectManyCheckboxAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
        initExamplesValues();
        initSelectItemsWithMapsAndArrays();
    }

    private void initComponentsAttributesList() {

        selectManyCheckboxAttributesList = new ArrayList<>();

        // The common "SelectOne"/"SelectMany" Components' attributes
        selectManyCheckboxAttributesList.addAll(commonHtmlAttributesService.getCommonSelectsAttributesList());

        selectManyCheckboxAttributesList.add(new ComponentsAttribute("collectionType", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Optional attribute that is a literal string that is the fully qualified class name of a concrete class that implements java.util.Collection, or an EL expression that evaluates to either 1. such a String, or 2. the Class object itself"));
        selectManyCheckboxAttributesList.add(new ComponentsAttribute("selectedClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to the rendered label on selected options"));
        selectManyCheckboxAttributesList.add(new ComponentsAttribute("unselectedClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to the rendered label on unselected options"));
        selectManyCheckboxAttributesList.add(new ComponentsAttribute("layout", false, "lineDirection", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Orientation of the options list to be created. Valid values are 'pageDirection' (list is laid out vertically), or 'lineDirection' (list is laid out horizontally). If not specified, the default value is 'lineDirection'"));
        selectManyCheckboxAttributesList.add(new ComponentsAttribute("border", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Width (in pixels) of the border to be drawn around the table containing the options list"));
        selectManyCheckboxAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }

    public List<ComponentsAttribute> getSelectManyCheckboxAttributesList() {
        return selectManyCheckboxAttributesList;
    }
}
