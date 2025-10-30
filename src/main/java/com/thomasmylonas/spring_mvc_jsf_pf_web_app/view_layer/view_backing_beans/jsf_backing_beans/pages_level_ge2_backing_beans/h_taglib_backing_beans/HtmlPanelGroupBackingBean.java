package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.GloballyCommonAttributesFlags;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlPanelGroupBackingBean")
@Getter
public class HtmlPanelGroupBackingBean extends HtmlTaglibBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};
    private static final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    private List<ComponentsAttribute> panelGroupAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        panelGroupAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding" - Alternative attributes: "styleClass")
        panelGroupAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributesWithFlags(
                        GloballyCommonAttributesFlags.builder()
                                .idAlt(false)
                                .valueAlt(false)
                                .renderedAlt(false)
                                .styleClassAlt(true)
                                .converterAlt(false)
                                .bindingAlt(false)
                                .build()
                ),
                EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        panelGroupAttributes.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributes(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        panelGroupAttributes.add(new ComponentsAttribute("layout", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The type of layout markup to use when rendering this group. If the value is 'block' the renderer must produce an HTML 'div' element. Otherwise HTML 'span' element must be produced"));
        panelGroupAttributes.add(new ComponentsAttribute("style", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style(s) to be applied when this component is rendered"));
    }
}
