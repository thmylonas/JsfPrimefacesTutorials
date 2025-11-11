package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlOutputFormatBackingBean")
@Getter
@Setter
public class HtmlOutputFormatBackingBean extends AbstractHtmlOutputsBackingBean {

    private List<ComponentsAttribute> outputFormatAttributes;

    // Parameters to be used in the 'value' attribute of <f:param>
    private final String param1;
    private final String param2;

    // Text with parameters to be used in the 'value' attribute of <h:outputFormat>
    private final String textWith2Params;
    private final String textWith2StyledParams;
    private final String textHello;
    private final String textHelloEscaped;
    private final String textHelloNotEscaped;
    private final String htmlInput;

    // Useful Strings to escape the special characters
    private final String escapeTrue;
    private final String escapeFalse;
    private final String lessGreaterThanSpecialChars;
    private final String lessThan;
    private final String greaterThan;

    public HtmlOutputFormatBackingBean() {

        param1 = "Item 1";
        param2 = "Item 2";
        textWith2Params = "Parameter_1: {0}, Parameter_2: {1}";
        textWith2StyledParams = "Parameter_1: " + highlightingSpan("{0}", COLOR_DEEP_PINK, "normal") +
                ", Parameter_2: " + highlightingSpan("{1}", COLOR_BLUE, "bold");
        //textWith2StyledParams = "Parameter_1: <span style=\"color:" + COLOR_DEEP_PINK + "\">{0}</span>, Parameter_2: <span style=\"color:" + COLOR_BLUE + "; font-weight:bold\">{1}</span>";
        textHello = "Hello {0}";
        textHelloEscaped = "With escape=\"true\": Hello &lt;span style=\"color:" + COLOR_DEEP_PINK + "\"&gt;{0}&lt;/span&gt;";
        textHelloNotEscaped = "With escape=\"false\": Hello &lt;span style=\"color:" + COLOR_DEEP_PINK + "\"&gt;{0}&lt;/span&gt;";
        htmlInput = "<input type=\"{0}\" {1}/>";
        escapeTrue = "\"true\"";
        escapeFalse = "\"false\"";
        lessGreaterThanSpecialChars = "&lt; &gt;";
        lessThan = "<";
        greaterThan = ">";
    }

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        outputFormatAttributes = new ArrayList<>();

        // The globally common Components' attributes
        outputFormatAttributes.addAll(commonHtmlAttributesService.initAndGetGloballyCommonAttributes());

        // The most common Components' attributes
        outputFormatAttributes.addAll(commonHtmlAttributesService.getMostCommonAttributes());

        outputFormatAttributes.add(new ComponentsAttribute("escape", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that characters that are sensitive in HTML and XML markup must be escaped. This flag is set to 'true' by default"));
    }
}
