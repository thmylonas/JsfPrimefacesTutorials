package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlPanelGridBackingBean")
public class HtmlPanelGridBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> panelGridAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        panelGridAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding")
        panelGridAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        panelGridAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        panelGridAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        // The common "Panels"/"Tables" Components' attributes
        panelGridAttributesList.addAll(commonHtmlAttributesService.getCommonPanelsTablesAttributesList());

        panelGridAttributesList.add(new ComponentsAttribute("columns", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of columns to render before starting a new row"));
    }

    public List<ComponentsAttribute> getPanelGridAttributesList() {
        return panelGridAttributesList;
    }
}
