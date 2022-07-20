package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlHeadBackingBean")
public class HtmlHeadBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> headAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "rendered", "styleClass", "converter"};
    private final String[] EXCLUDED_MOST_COMMON_ATTRIBUTES = {"role", "style", "title"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        headAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "binding")
        headAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The most common Components' attributes (Containing attributes: "dir", "lang")
        headAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getMostCommonAttributesList(), EXCLUDED_MOST_COMMON_ATTRIBUTES));

        headAttributesList.add(new ComponentsAttribute("xmlns", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "An XML Namespace to be passed through to the rendered element"));
    }

    public List<ComponentsAttribute> getHeadAttributesList() {
        return headAttributesList;
    }
}
