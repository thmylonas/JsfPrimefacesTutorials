package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlOutputStylesheetBackingBean")
@Getter
public class HtmlOutputStylesheetBackingBean extends AbstractHtmlOutputsBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"styleClass"};

    private List<ComponentsAttribute> outputStylesheetAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        outputStylesheetAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "converter", "binding")
        outputStylesheetAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        outputStylesheetAttributesList.add(new ComponentsAttribute("library", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The libraryName for this resource"));
        outputStylesheetAttributesList.add(new ComponentsAttribute("name", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The resourceName for this resource. This attribute is required if the stylesheet is NOT inline"));
        outputStylesheetAttributesList.add(new ComponentsAttribute("media", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The media type for this stylesheet. For example, media='screen' would cause the resource to be rendered with the media attribute of the link set to screen"));
    }
}
