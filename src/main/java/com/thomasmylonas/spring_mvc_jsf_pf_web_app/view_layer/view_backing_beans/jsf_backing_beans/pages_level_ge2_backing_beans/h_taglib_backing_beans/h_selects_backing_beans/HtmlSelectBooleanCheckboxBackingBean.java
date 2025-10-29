package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models.GenericArray;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.GloballyCommonAttributesFlags;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectsBackingBean;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "htmlSelectBooleanCheckboxBackingBean")
@Getter
@Setter
public class HtmlSelectBooleanCheckboxBackingBean extends AbstractHtmlSelectsBackingBean {

    private List<ComponentsAttribute> selectBooleanCheckboxAttributesList;

    // Variables used in the "value" attribute of "h:selectBooleanCheckbox" component
    private boolean agree;
    private boolean agree1;
    private boolean agree2;

    @PostConstruct
    private void init() {
        initComponentsAttributesList();
        initExamplesValues();
    }

    private void initComponentsAttributesList() {

        selectBooleanCheckboxAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Alternative attributes: "value", "converter")
        selectBooleanCheckboxAttributesList.addAll(commonHtmlAttributesService.initAndGetGloballyCommonAttributesListWithFlags(
                        GloballyCommonAttributesFlags.builder()
                                .idAlt(false)
                                .valueAlt(true)
                                .renderedAlt(false)
                                .styleClassAlt(false)
                                .converterAlt(true)
                                .bindingAlt(false)
                                .build()
                )
        );

        // The common "UIInput" Components' attributes
        List<String> globallyCommonNameAttributesList = commonHtmlAttributesService.initAndGetGloballyCommonAttributesList().stream().map(ComponentsAttribute::getName).collect(Collectors.toList());
        selectBooleanCheckboxAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.getCommonUiInputsAttributesList(), HelperClass.transformListToArray(globallyCommonNameAttributesList, new GenericArray<>(String.class, 0))));

        selectBooleanCheckboxAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }

    protected void initExamplesValues() {

        // Pre-selected values of "h:selectBooleanCheckbox" component
        agree = false;
        agree1 = true;
        agree2 = false;
    }

    public void resetValues() {
        initExamplesValues();
    }
}
