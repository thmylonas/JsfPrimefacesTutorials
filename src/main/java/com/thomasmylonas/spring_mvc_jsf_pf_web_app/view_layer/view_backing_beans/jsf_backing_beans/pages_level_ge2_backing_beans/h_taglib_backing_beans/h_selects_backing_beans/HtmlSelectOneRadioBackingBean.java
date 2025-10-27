package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectOneBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "htmlSelectOneRadioBackingBean")
public class HtmlSelectOneRadioBackingBean extends AbstractHtmlSelectOneBackingBean {

    private List<ComponentsAttribute> selectOneRadioAttributesList;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
        initExamplesValues();
        initSelectItemsWithMapsAndArrays();
    }

    private void initComponentsAttributesList() {

        selectOneRadioAttributesList = new ArrayList<>();

        // The common "SelectOne"/"SelectMany" Components' attributes (Alternative attributes: "enabledClass", "disabledClass")
        selectOneRadioAttributesList.addAll(commonHtmlAttributesService.getCommonSelectsAttributesListWithFlags(true, true));

        selectOneRadioAttributesList.add(new ComponentsAttribute("layout", false, "lineDirection", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Orientation of the options list to be created. Valid values are 'pageDirection' (list is laid out vertically), or 'lineDirection' (list is laid out horizontally). If not specified, the default value is 'lineDirection'. This attribute is ignored when 'group' attribute is specified"));
        selectOneRadioAttributesList.add(new ComponentsAttribute("border", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Width (in pixels) of the border to be drawn around the table containing the options list. This attribute is ignored when 'group' attribute is specified"));
        selectOneRadioAttributesList.add(new ComponentsAttribute("group", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Specifies the name of the radio button group. Radio button components having the same group within a UIForm parent will uncheck all others when being checked. If the value attribute is absent then the one from first component of the group will be used. If the UISelectItem child is absent then the one from first component of the group will be used. When specified, the group attribute disables the default rendering of the 'table' element and any attribute related to the rendering of the 'table' element, such as 'border', is ignored"));
        selectOneRadioAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }

    public List<ComponentsAttribute> getSelectOneRadioAttributesList() {
        return selectOneRadioAttributesList;
    }
}
