package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans._base;

import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans._base.AbstractBackingBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractJsfBackingBean extends AbstractBackingBean {

    /**
     * This method excludes from the "attributes" all the attributes "attrsNames[]"
     *
     * @param attributes The list to exclude from
     * @param attrsNames     The attribute name to exclude
     * @return The modified "attributes"
     */
    protected List<ComponentsAttribute> excludeAttributes(List<ComponentsAttribute> attributes, String... attrsNames) {

        if (HelperClass.isListNullOrEmpty(attributes)) {
            return Collections.emptyList();
        }
        if (HelperClass.isArrayNullOrEmpty(attrsNames)) {
            return attributes; // The list is returned unchanged
        }
        List<ComponentsAttribute> resultList = new ArrayList<>(attributes);

        for (String attrToExclude : attrsNames) {
            // attributes.removeIf(attr -> attrToExclude.equalsIgnoreCase(attr.getName()));
            for (ComponentsAttribute attr : attributes) {
                if (attrToExclude.equalsIgnoreCase(attr.getName())) {
                    resultList.remove(attr);
                }
            }
        }
        //resultList.forEach(attr -> System.out.print(attr.getName() + " "));
        return resultList;
    }

    @Deprecated
    protected List<ComponentsAttribute> includeAttributes(List<ComponentsAttribute> attributes, ComponentsAttribute... attrs) {

        if (attributes == null) { // The condition "attributes.isEmpty()" is acceptable
            return Collections.emptyList();
        }
        if (HelperClass.isArrayNullOrEmpty(attrs)) {
            return attributes; // The list is returned unchanged
        }
        List<ComponentsAttribute> resultList = new ArrayList<>(attributes);

        boolean found = false;
        for (ComponentsAttribute attrToInclude : attrs) {
            for (ComponentsAttribute attr : attributes) {
                if (attrToInclude.getName().equalsIgnoreCase(attr.getName())) {
                    found = true;
                    break;
                }
            }
            if (found) {
                found = false;
                continue;
            }
            resultList.add(attrToInclude);
        }
        //resultList.forEach(attr -> System.out.print(attr.getName() + " "));
        return resultList;
    }
}
