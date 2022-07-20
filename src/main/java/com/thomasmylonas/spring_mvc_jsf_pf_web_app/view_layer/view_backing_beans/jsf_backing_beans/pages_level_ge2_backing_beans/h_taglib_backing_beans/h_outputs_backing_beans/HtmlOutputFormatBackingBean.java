package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_outputs_backing_beans._base.AbstractHtmlOutputsBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlOutputFormatBackingBean")
public class HtmlOutputFormatBackingBean extends AbstractHtmlOutputsBackingBean {

    private List<ComponentsAttribute> outputFormatAttributesList;

    // Text with parameters to be used in the 'value' attribute of <h:outputFormat>
    private String textWith2Params;
    private String textWith2StyledParams;
    private String textHello;
    private String textHelloEscaped;
    private String textHelloNotEscaped;
    private String htmlInput;

    // Useful Strings to escape the special characters
    private String fieldValue;
    private String escapeTrue;
    private String escapeFalse;
    private String egSpecialChars;
    private String lessThan;
    private String greaterThan;

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
        outputFormatAttributesList.addAll(commonHtmlAttributesService.getGloballyCommonAttributesList());

        // The most common Components' attributes
        outputFormatAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        outputFormatAttributesList.add(new ComponentsAttribute("escape", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that characters that are sensitive in HTML and XML markup must be escaped. This flag is set to 'true' by default"));
    }

    public List<ComponentsAttribute> getOutputFormatAttributesList() {
        return outputFormatAttributesList;
    }

    public String getTextWith2Params() {
        return textWith2Params;
    }

    public String getTextWith2StyledParams() {
        return textWith2StyledParams;
    }

    public String getTextHello() {
        return textHello;
    }

    public String getTextHelloEscaped() {
        return textHelloEscaped;
    }

    public String getTextHelloNotEscaped() {
        return textHelloNotEscaped;
    }

    public String getHtmlInput() {
        return htmlInput;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public String getEscapeTrue() {
        return escapeTrue;
    }

    public String getEscapeFalse() {
        return escapeFalse;
    }

    public String getEgSpecialChars() {
        return egSpecialChars;
    }

    public String getLessThan() {
        return lessThan;
    }

    public String getGreaterThan() {
        return greaterThan;
    }
}
