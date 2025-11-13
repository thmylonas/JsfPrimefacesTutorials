package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base;

import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractHtmlSelectManyBackingBean extends AbstractHtmlSelectsBackingBean {

    // Variables used in the "value" attribute of "HtmlSelectMany" components

    protected String[] itemDataValues;
    protected String[] itemDataNoPreSelectValues;
    protected String[] javaFrameworksHardCodedValues;
    protected String[] javaFrameworksWithSelectItemsValueLabelArrayValues;
    protected String[] javaFrameworksWithSelectItemsValueArrayValues;
    protected String[] javaFrameworksWithSelectItemsAllAttrsArrayValues;
    protected String[] javaFrameworksWithStringValuesArrayValues;
    protected String[] selectItemGroupsArrayValues;
    protected String[] javaFrameworksWithLabelValueMapValues;
    protected String[] javaFrameworksWithValueLabelMapValues;
    protected String[] javaFrameworksWithObjectArrayValues;

    protected void initExamplesValues() {

        // Pre-selected values of "HtmlSelectMany" components
        itemDataValues = new String[]{"Item value 1", "Item value 2"};
        javaFrameworksHardCodedValues = new String[]{"Java Value", "Spring Framework Value"};
        javaFrameworksWithSelectItemsValueLabelArrayValues = new String[]{"Java Value", "Spring Framework Value"};
        javaFrameworksWithSelectItemsValueArrayValues = new String[]{"Java Value", "Spring Framework Value"};
        javaFrameworksWithSelectItemsAllAttrsArrayValues = new String[]{"Java Value", "Spring Framework Value"};
        javaFrameworksWithStringValuesArrayValues = new String[]{"Java Value", "Spring Framework Value"};
        selectItemGroupsArrayValues = new String[]{"Java Value", "HTML Value"};
        javaFrameworksWithLabelValueMapValues = new String[]{"Java Value", "Spring Framework Value"};
        javaFrameworksWithValueLabelMapValues = new String[]{"Java Value", "Spring Framework Value"};
        javaFrameworksWithObjectArrayValues = new String[]{"Java Value", "Spring Framework Value"};
    }

    public String displayItemValues(String[] itemValues) {
        return itemValues == null ? "[ ]" : HelperClass.displayStringListAsString(itemValues, HelperClass.DISPLAY_INLINE_IN_CONSOLE);
    }

    public void resetValues() {
        initExamplesValues();
    }
}
