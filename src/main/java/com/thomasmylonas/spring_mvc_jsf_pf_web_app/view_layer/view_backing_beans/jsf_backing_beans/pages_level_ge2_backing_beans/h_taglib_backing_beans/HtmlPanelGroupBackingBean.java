package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.GloballyCommonAttributesFlags;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.HtmlTaglibBackingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "htmlPanelGroupBackingBean")
public class HtmlPanelGroupBackingBean extends HtmlTaglibBackingBean {

    private List<ComponentsAttribute> panelGroupAttributesList;

    private final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"value", "converter"};
    private final String[] EXCLUDED_EVENT_HANDLER_ATTRIBUTES = {"onfocus", "onblur", "onselect", "onchange"};

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        panelGroupAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "rendered", "styleClass", "binding" - Alternative attributes: "styleClass")
        panelGroupAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getGloballyCommonAttributesListWithFlags(
                        new GloballyCommonAttributesFlags.Builder()
                                .isIdAlt(false).isValueAlt(false).isRenderedAlt(false).isStyleClassAlt(true).isConverterAlt(false).isBindingAlt(false).build()),
                EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The attributes which are handling events
        panelGroupAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonEventHandlerAttributesList(), EXCLUDED_EVENT_HANDLER_ATTRIBUTES));

        panelGroupAttributesList.add(new ComponentsAttribute("layout", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The type of layout markup to use when rendering this group. If the value is 'block' the renderer must produce an HTML 'div' element. Otherwise HTML 'span' element must be produced"));
        panelGroupAttributesList.add(new ComponentsAttribute("style", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style(s) to be applied when this component is rendered"));
    }

    public List<ComponentsAttribute> getPanelGroupAttributesList() {
        return panelGroupAttributesList;
    }
}
