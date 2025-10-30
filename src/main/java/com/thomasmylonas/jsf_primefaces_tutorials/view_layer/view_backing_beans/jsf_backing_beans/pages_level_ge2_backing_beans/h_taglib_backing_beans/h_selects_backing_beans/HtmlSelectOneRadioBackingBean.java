package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectOneBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlSelectOneRadioBackingBean")
@Getter
public class HtmlSelectOneRadioBackingBean extends AbstractHtmlSelectOneBackingBean {

    private List<ComponentsAttribute> selectOneRadioAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
        initExamplesValues();
        initSelectItemsWithMapsAndArrays();
    }

    private void initComponentsAttributes() {

        selectOneRadioAttributes = new ArrayList<>();

        // The common "SelectOne"/"SelectMany" Components' attributes (Alternative attributes: "enabledClass", "disabledClass")
        selectOneRadioAttributes.addAll(commonHtmlAttributesService.initAndGetCommonSelectsAttributesWithFlags(true, true));

        selectOneRadioAttributes.add(new ComponentsAttribute("layout", false, "lineDirection", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Orientation of the options list to be created. Valid values are 'pageDirection' (list is laid out vertically), or 'lineDirection' (list is laid out horizontally). If not specified, the default value is 'lineDirection'. This attribute is ignored when 'group' attribute is specified"));
        selectOneRadioAttributes.add(new ComponentsAttribute("border", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Width (in pixels) of the border to be drawn around the table containing the options list. This attribute is ignored when 'group' attribute is specified"));
        selectOneRadioAttributes.add(new ComponentsAttribute("group", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Specifies the name of the radio button group. Radio button components having the same group within a UIForm parent will uncheck all others when being checked. If the value attribute is absent then the one from first component of the group will be used. If the UISelectItem child is absent then the one from first component of the group will be used. When specified, the group attribute disables the default rendering of the 'table' element and any attribute related to the rendering of the 'table' element, such as 'border', is ignored"));
        selectOneRadioAttributes.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }
}
