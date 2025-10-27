package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.GloballyCommonAttributesFlags;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlColumnBackingBean")
public class HtmlColumnBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> columnAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "styleClass", "converter"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        columnAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "binding" - Alternative attributes: "id", "rendered", "binding")
        columnAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesListWithFlags(
                        new GloballyCommonAttributesFlags.Builder()
                                .isIdAlt(true).isValueAlt(false).isRenderedAlt(true).isStyleClassAlt(false).isConverterAlt(false).isBindingAlt(true).build()),
                EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        columnAttributesList.addAll(commonHtmlAttributesService.getCommonEventHandlerAttributesList());

        columnAttributesList.add(new ComponentsAttribute("headerClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to any column header generated for this table"));
        columnAttributesList.add(new ComponentsAttribute("footerClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to any column footer generated for this table"));
        columnAttributesList.add(new ComponentsAttribute("footerClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to the 'td' of this column")); // Specific feature of JSF 2.3
        columnAttributesList.add(new ComponentsAttribute("rowHeader", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this column is a row header column and therefore cells in this column should be rendered with 'th' instead of 'td' and must have the 'scope='row'' attribute"));
    }

    public List<ComponentsAttribute> getColumnAttributesList() {
        return columnAttributesList;
    }
}
