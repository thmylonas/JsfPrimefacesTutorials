package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlGraphicImageBackingBean")
public class HtmlGraphicImageBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> graphicImageAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"converter"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        graphicImageAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "styleClass", "binding")
        graphicImageAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        graphicImageAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        // The most common Components' attributes
        graphicImageAttributesList.addAll(commonHtmlAttributesService.getMostCommonAttributesList());

        graphicImageAttributesList.add(new ComponentsAttribute("url", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Context-relative URL to retrieve the resource associated with this component. This is an alias for the 'value' property"));
        graphicImageAttributesList.add(new ComponentsAttribute("alt", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Alternate textual description of the element rendered by this component"));
        graphicImageAttributesList.add(new ComponentsAttribute("width", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Override for the width of this image"));
        graphicImageAttributesList.add(new ComponentsAttribute("height", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Override for the height of this image"));
        graphicImageAttributesList.add(new ComponentsAttribute("name", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The resourceName for this resource"));
        graphicImageAttributesList.add(new ComponentsAttribute("library", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The libraryName for this resource"));
        graphicImageAttributesList.add(new ComponentsAttribute("longdesc", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "URI to a long description of the image represented by this element"));
        graphicImageAttributesList.add(new ComponentsAttribute("ismap", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this image is to be used as a server side image map. Such an image must be enclosed within a hyperlink ('a'). A value of false causes no attribute to be rendered, while a value of true causes the attribute to be rendered as ismap='ismap'"));
        graphicImageAttributesList.add(new ComponentsAttribute("usemap", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The name of a client side image map (an HTML 'map' element) for which this element provides the image"));
    }

    public List<ComponentsAttribute> getGraphicImageAttributesList() {
        return graphicImageAttributesList;
    }
}
