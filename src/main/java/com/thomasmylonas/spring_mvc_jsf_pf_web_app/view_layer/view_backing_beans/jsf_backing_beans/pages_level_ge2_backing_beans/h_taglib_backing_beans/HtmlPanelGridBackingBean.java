package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlPanelGridBackingBean")
@Getter
public class HtmlPanelGridBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};
    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    private List<ComponentsAttribute> panelGridAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        panelGridAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding")
        panelGridAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        panelGridAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        panelGridAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        // The common "Panels"/"Tables" Components' attributes
        panelGridAttributes.addAll(commonHtmlAttributesService.getCommonPanelsTablesAttributes());

        panelGridAttributes.add(new ComponentsAttribute("columns", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "The number of columns to render before starting a new row"));
    }
}
