package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractHtmlSelectOneBackingBean extends AbstractHtmlSelectsBackingBean {

    // Variables used in the "value" attribute of "HtmlSelectOne" components

    protected String itemDataValue;
    protected String itemDataNoPreSelectValue;
    protected String javaFrameworksHardCodedValue;
    protected String javaFrameworksWithSelectItemsValueLabelArrayValue;
    protected String javaFrameworksWithSelectItemsValueArrayValue;
    protected String javaFrameworksWithSelectItemsAllAttrsArrayValue;
    protected String javaFrameworksWithStringValuesArrayValue;
    protected String selectItemGroupsArrayValue;
    protected String javaFrameworksWithLabelValueMapValue;
    protected String javaFrameworksWithValueLabelMapValue;
    protected String javaFrameworksWithObjectArrayValue;

    protected void initExamplesValues() {

        // Pre-selected values of "HtmlSelectOne" components
        itemDataValue = "Item value 1";
        javaFrameworksHardCodedValue = "Java Value";
        javaFrameworksWithSelectItemsValueLabelArrayValue = "Java Value";
        javaFrameworksWithSelectItemsValueArrayValue = "Java Value";
        javaFrameworksWithSelectItemsAllAttrsArrayValue = "Java Value";
        javaFrameworksWithStringValuesArrayValue = "Java Value";
        selectItemGroupsArrayValue = "Java Value";
        javaFrameworksWithLabelValueMapValue = "Java Value";
        javaFrameworksWithValueLabelMapValue = "Java Value";
        javaFrameworksWithObjectArrayValue = "Java Value";
    }

    public void resetValues() {
        initExamplesValues();
    }
}
