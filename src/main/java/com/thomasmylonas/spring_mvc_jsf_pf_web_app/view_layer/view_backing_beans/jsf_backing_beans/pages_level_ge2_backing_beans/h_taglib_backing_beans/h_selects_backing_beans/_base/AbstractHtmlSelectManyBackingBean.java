package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.DisplayConstants;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;

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

    public String[] getItemDataValues() {
        return itemDataValues;
    }

    public void setItemDataValues(String[] itemDataValues) {
        this.itemDataValues = itemDataValues;
    }

    public String[] getItemDataNoPreSelectValues() {
        return itemDataNoPreSelectValues;
    }

    public void setItemDataNoPreSelectValues(String[] itemDataNoPreSelectValues) {
        this.itemDataNoPreSelectValues = itemDataNoPreSelectValues;
    }

    public String[] getJavaFrameworksHardCodedValues() {
        return javaFrameworksHardCodedValues;
    }

    public void setJavaFrameworksHardCodedValues(String[] javaFrameworksHardCodedValues) {
        this.javaFrameworksHardCodedValues = javaFrameworksHardCodedValues;
    }

    public String[] getJavaFrameworksWithSelectItemsValueLabelArrayValues() {
        return javaFrameworksWithSelectItemsValueLabelArrayValues;
    }

    public void setJavaFrameworksWithSelectItemsValueLabelArrayValues(String[] javaFrameworksWithSelectItemsValueLabelArrayValues) {
        this.javaFrameworksWithSelectItemsValueLabelArrayValues = javaFrameworksWithSelectItemsValueLabelArrayValues;
    }

    public String[] getJavaFrameworksWithSelectItemsValueArrayValues() {
        return javaFrameworksWithSelectItemsValueArrayValues;
    }

    public void setJavaFrameworksWithSelectItemsValueArrayValues(String[] javaFrameworksWithSelectItemsValueArrayValues) {
        this.javaFrameworksWithSelectItemsValueArrayValues = javaFrameworksWithSelectItemsValueArrayValues;
    }

    public String[] getJavaFrameworksWithSelectItemsAllAttrsArrayValues() {
        return javaFrameworksWithSelectItemsAllAttrsArrayValues;
    }

    public void setJavaFrameworksWithSelectItemsAllAttrsArrayValues(String[] javaFrameworksWithSelectItemsAllAttrsArrayValues) {
        this.javaFrameworksWithSelectItemsAllAttrsArrayValues = javaFrameworksWithSelectItemsAllAttrsArrayValues;
    }

    public String[] getJavaFrameworksWithStringValuesArrayValues() {
        return javaFrameworksWithStringValuesArrayValues;
    }

    public void setJavaFrameworksWithStringValuesArrayValues(String[] javaFrameworksWithStringValuesArrayValues) {
        this.javaFrameworksWithStringValuesArrayValues = javaFrameworksWithStringValuesArrayValues;
    }

    public String[] getSelectItemGroupsArrayValues() {
        return selectItemGroupsArrayValues;
    }

    public void setSelectItemGroupsArrayValues(String[] selectItemGroupsArrayValues) {
        this.selectItemGroupsArrayValues = selectItemGroupsArrayValues;
    }

    public String[] getJavaFrameworksWithLabelValueMapValues() {
        return javaFrameworksWithLabelValueMapValues;
    }

    public void setJavaFrameworksWithLabelValueMapValues(String[] javaFrameworksWithLabelValueMapValues) {
        this.javaFrameworksWithLabelValueMapValues = javaFrameworksWithLabelValueMapValues;
    }

    public String[] getJavaFrameworksWithValueLabelMapValues() {
        return javaFrameworksWithValueLabelMapValues;
    }

    public void setJavaFrameworksWithValueLabelMapValues(String[] javaFrameworksWithValueLabelMapValues) {
        this.javaFrameworksWithValueLabelMapValues = javaFrameworksWithValueLabelMapValues;
    }

    public String[] getJavaFrameworksWithObjectArrayValues() {
        return javaFrameworksWithObjectArrayValues;
    }

    public void setJavaFrameworksWithObjectArrayValues(String[] javaFrameworksWithObjectArrayValues) {
        this.javaFrameworksWithObjectArrayValues = javaFrameworksWithObjectArrayValues;
    }

    public String displayItemValues(String[] itemValues) {
        return itemValues == null ? "[ ]" : HelperClass.displayStringListAsString(itemValues, DisplayConstants.DISPLAY_INLINE_IN_CONSOLE);
    }

    public void resetValues() {
        initExamplesValues();
    }
}
