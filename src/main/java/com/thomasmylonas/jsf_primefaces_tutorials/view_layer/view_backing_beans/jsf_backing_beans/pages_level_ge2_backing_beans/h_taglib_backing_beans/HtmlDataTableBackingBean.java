package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlDataTableBackingBean")
@Getter
public class HtmlDataTableBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};
    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    private List<ComponentsAttribute> dataTableAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        dataTableAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        dataTableAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        dataTableAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        dataTableAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        // The common "Panels"/"Tables" Components' attributes
        dataTableAttributes.addAll(commonHtmlAttributesService.getCommonPanelsTablesAttributes());

        dataTableAttributes.add(new ComponentsAttribute("first", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Zero-relative row number of the first row to be displayed. If this property is set to zero, rendering will begin with the first row of the underlying data"));
        dataTableAttributes.add(new ComponentsAttribute("rowStatePreserved", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Boolean flag directing how the per-row component state should be handled. See UIData.setRowStatePreserved for more information"));
        dataTableAttributes.add(new ComponentsAttribute("rows", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of rows to display, starting with the one identified by the 'first' property. If this value is set to zero, all available rows in the underlying data model will be displayed"));
        dataTableAttributes.add(new ComponentsAttribute("var", false, "No default value", "java.lang.String", "Name of a request-scope attribute under which the model data for the row selected by the current value of the 'rowIndex' property (i.e. also the current value of the 'rowData' property) will be exposed"));
    }
}
