package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.GloballyCommonAttributesFlags;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlColumnBackingBean")
@Getter
public class HtmlColumnBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "styleClass", "converter"};

    private List<ComponentsAttribute> columnAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        columnAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "binding" - Alternative attributes: "id", "rendered", "binding")
        columnAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributesWithFlags(
                        GloballyCommonAttributesFlags.builder()
                                .idAlt(true)
                                .valueAlt(false)
                                .renderedAlt(true)
                                .styleClassAlt(false)
                                .converterAlt(false)
                                .bindingAlt(true)
                                .build()
                ),
                EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        columnAttributes.add(new ComponentsAttribute("headerClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to any column header generated for this table"));
        columnAttributes.add(new ComponentsAttribute("footerClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to any column footer generated for this table"));
        columnAttributes.add(new ComponentsAttribute("footerClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to the 'td' of this column")); // Specific feature of JSF 2.3
        columnAttributes.add(new ComponentsAttribute("rowHeader", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this column is a row header column and therefore cells in this column should be rendered with 'th' instead of 'td' and must have the 'scope='row'' attribute"));
    }
}
