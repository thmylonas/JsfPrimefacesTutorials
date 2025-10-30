package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectManyBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlSelectManyCheckboxBackingBean")
@Getter
public class HtmlSelectManyCheckboxBackingBean extends AbstractHtmlSelectManyBackingBean {

    private List<ComponentsAttribute> selectManyCheckboxAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
        initExamplesValues();
        initSelectItemsWithMapsAndArrays();
    }

    private void initComponentsAttributes() {

        selectManyCheckboxAttributes = new ArrayList<>();

        // The common "SelectOne"/"SelectMany" Components' attributes
        selectManyCheckboxAttributes.addAll(commonHtmlAttributesService.initAndGetCommonSelectsAttributes());

        selectManyCheckboxAttributes.add(new ComponentsAttribute("collectionType", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Optional attribute that is a literal string that is the fully qualified class name of a concrete class that implements java.util.Collection, or an EL expression that evaluates to either 1. such a String, or 2. the Class object itself"));
        selectManyCheckboxAttributes.add(new ComponentsAttribute("selectedClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to the rendered label on selected options"));
        selectManyCheckboxAttributes.add(new ComponentsAttribute("unselectedClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to the rendered label on unselected options"));
        selectManyCheckboxAttributes.add(new ComponentsAttribute("layout", false, "lineDirection", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Orientation of the options list to be created. Valid values are 'pageDirection' (list is laid out vertically), or 'lineDirection' (list is laid out horizontally). If not specified, the default value is 'lineDirection'"));
        selectManyCheckboxAttributes.add(new ComponentsAttribute("border", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Width (in pixels) of the border to be drawn around the table containing the options list"));
        selectManyCheckboxAttributes.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }
}
