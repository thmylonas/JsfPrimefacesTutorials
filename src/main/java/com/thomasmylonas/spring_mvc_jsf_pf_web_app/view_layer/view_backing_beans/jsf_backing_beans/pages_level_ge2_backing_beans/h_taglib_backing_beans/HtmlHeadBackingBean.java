package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlHeadBackingBean")
@Getter
public class HtmlHeadBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "rendered", "styleClass", "converter"};
    private static final String[] EXCLUDED_MOST_COMMON_ATTRIBUTES = {"role", "style", "title"};

    private List<ComponentsAttribute> headAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        headAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "binding")
        headAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The most common Components' attributes (Containing attributes: "dir", "lang")
        headAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getMostCommonAttributes(), EXCLUDED_MOST_COMMON_ATTRIBUTES));

        headAttributes.add(new ComponentsAttribute("xmlns", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "An XML Namespace to be passed through to the rendered element"));
    }
}
