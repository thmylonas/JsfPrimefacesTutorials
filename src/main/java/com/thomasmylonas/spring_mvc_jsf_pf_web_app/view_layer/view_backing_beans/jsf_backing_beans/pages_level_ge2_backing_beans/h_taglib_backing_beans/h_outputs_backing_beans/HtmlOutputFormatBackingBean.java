package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlOutputFormatBackingBean")
@Getter
public class HtmlOutputFormatBackingBean extends AbstractHtmlOutputsBackingBean {

    private List<ComponentsAttribute> outputFormatAttributesList;

    // Text with parameters to be used in the 'value' attribute of <h:outputFormat>
    private final String textWith2Params;
    private final String textWith2StyledParams;
    private final String textHello;
    private final String textHelloEscaped;
    private final String textHelloNotEscaped;
    private final String htmlInput;

    // Useful Strings to escape the special characters
    private final String fieldValue;
    private final String escapeTrue;
    private final String escapeFalse;
    private final String egSpecialChars;
    private final String lessThan;
    private final String greaterThan;

    public HtmlOutputFormatBackingBean() {

        textWith2Params = "parameter 1: {0}, parameter 2: {1}";
        textWith2StyledParams = "parameter 1: " + highlightingSpan("{0}", COLOR_DEEP_PINK, "normal") +
                ", parameter 2: " + highlightingSpan("{1}", COLOR_BLUE, "bold");
        //textWith2StyledParams = "parameter 1: <span style=\"color:" + COLOR_DEEP_PINK + "\">{0}</span>, parameter 2: <span style=\"color:" + COLOR_BLUE + "; font-weight:bold\">{1}</span>";
        textHello = "Hello {0}";
        textHelloEscaped = "With escape=\"true\": Hello &lt;span style=\"color:" + COLOR_DEEP_PINK + "\"&gt;{0}&lt;/span&gt;";
        textHelloNotEscaped = "With escape=\"false\": Hello &lt;span style=\"color:" + COLOR_DEEP_PINK + "\"&gt;{0}&lt;/span&gt;";
        htmlInput = "<input type=\"{0}\" {1}/>";
        fieldValue = "#{field_value}";
        escapeTrue = "\"true\"";
        escapeFalse = "\"false\"";
        egSpecialChars = "&lt; &gt;";
        lessThan = "<";
        greaterThan = ">";
    }

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        outputFormatAttributesList = new ArrayList<>();

        // The globally common Components' attributes
        outputFormatAttributesList.addAll(commonHtmlAttributesService.initAndGetGloballyCommonAttributesList());

        // The most common Components' attributes
        outputFormatAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        outputFormatAttributesList.add(new ComponentsAttribute("escape", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that characters that are sensitive in HTML and XML markup must be escaped. This flag is set to 'true' by default"));
    }
}
