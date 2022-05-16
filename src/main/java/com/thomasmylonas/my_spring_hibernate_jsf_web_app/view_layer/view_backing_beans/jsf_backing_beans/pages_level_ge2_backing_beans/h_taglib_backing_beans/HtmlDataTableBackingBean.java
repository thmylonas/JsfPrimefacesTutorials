package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlDataTableBackingBean")
public class HtmlDataTableBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> dataTableAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        dataTableAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        dataTableAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        dataTableAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        dataTableAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The common "Panels"/"Tables" Components' attributes
        dataTableAttributesList.addAll(commonHtmlAttributesService.getCommonPanelsTablesAttributesList());

        dataTableAttributesList.add(new ComponentsAttribute("first", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Zero-relative row number of the first row to be displayed. If this property is set to zero, rendering will begin with the first row of the underlying data"));
        dataTableAttributesList.add(new ComponentsAttribute("rowStatePreserved", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Boolean flag directing how the per-row component state should be handled. See UIData.setRowStatePreserved for more information"));
        dataTableAttributesList.add(new ComponentsAttribute("rows", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of rows to display, starting with the one identified by the 'first' property. If this value is set to zero, all available rows in the underlying data model will be displayed"));
        dataTableAttributesList.add(new ComponentsAttribute("var", false, "No default value", "java.lang.String", "Name of a request-scope attribute under which the model data for the row selected by the current value of the 'rowIndex' property (i.e. also the current value of the 'rowData' property) will be exposed"));
    }

    public List<ComponentsAttribute> getDataTableAttributesList() {
        return dataTableAttributesList;
    }
}
