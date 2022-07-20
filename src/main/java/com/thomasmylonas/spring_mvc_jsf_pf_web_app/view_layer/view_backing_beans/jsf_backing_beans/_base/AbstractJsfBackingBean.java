package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractJsfBackingBean extends AbstractBackingBean {

    /**
     * This method excludes from the "attributesList" all the attributes "attrsNames[]"
     *
     * @param attributesList The list to exclude from
     * @param attrsNames     The attribute name to exclude
     * @return The modified "attributesList"
     */
    protected List<ComponentsAttribute> excludeAttributes(List<ComponentsAttribute> attributesList, String... attrsNames) {

        if (HelperClass.isListNullOrEmpty(attributesList)) {
            return Collections.emptyList();
        }
        if (HelperClass.isArrayNullOrEmpty(attrsNames)) {
            return attributesList; // The list is returned unchanged
        }
        List<ComponentsAttribute> resultList = new ArrayList<>(attributesList);

        for (String attrToExclude : attrsNames) {
            // attributesList.removeIf(attr -> attrToExclude.equalsIgnoreCase(attr.getName()));
            for (ComponentsAttribute attr : attributesList) {
                if (attrToExclude.equalsIgnoreCase(attr.getName())) {
                    resultList.remove(attr);
                }
            }
        }
        //resultList.forEach(attr -> System.out.print(attr.getName() + " "));
        return resultList;
    }

    @Deprecated
    protected List<ComponentsAttribute> includeAttributes(List<ComponentsAttribute> attributesList, ComponentsAttribute... attrs) {

        if (attributesList == null) { // The condition "attributesList.isEmpty()" is acceptable
            return Collections.emptyList();
        }
        if (HelperClass.isArrayNullOrEmpty(attrs)) {
            return attributesList; // The list is returned unchanged
        }
        List<ComponentsAttribute> resultList = new ArrayList<>(attributesList);

        boolean found = false;
        for (ComponentsAttribute attrToInclude : attrs) {
            for (ComponentsAttribute attr : attributesList) {
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
