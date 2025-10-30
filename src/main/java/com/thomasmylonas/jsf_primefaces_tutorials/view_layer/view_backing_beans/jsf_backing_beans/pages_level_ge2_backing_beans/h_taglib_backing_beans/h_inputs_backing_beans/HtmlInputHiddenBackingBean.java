package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models._general_models.GenericArray;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "htmlInputHiddenBackingBean")
@Getter
public class HtmlInputHiddenBackingBean extends AbstractHtmlInputsBackingBean {

    private static final String[] EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES = {"styleClass"};

    private List<ComponentsAttribute> inputHiddenAttributes;

    @PostConstruct
    private void init() {
        initCommonHtmlInputsAttributes();
        initComponentsAttributes();
    }

    private void initComponentsAttributes() {

        inputHiddenAttributes = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "converter", "binding")
        inputHiddenAttributes.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributes(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The common "UIInput" Components' attributes
        List<String> globallyCommonNameAttributes = commonHtmlAttributesService.initAndGetGloballyCommonAttributes().stream().map(ComponentsAttribute::getName).collect(Collectors.toList());
        List<String> commonEventHandlerNameAttributes = commonHtmlAttributesService.getCommonEventHandlerAttributes().stream().map(ComponentsAttribute::getName).collect(Collectors.toList());
        List<String> subsetUiInputsNameAttributes = commonHtmlAttributesService.getSubsetUiInputsAttributes().stream().map(ComponentsAttribute::getName).collect(Collectors.toList());
        List<ComponentsAttribute> tempCommonUiInputsAttributes = excludeAttributes(commonHtmlAttributesService.getCommonUiInputsAttributes(), HelperClass.transformListToArray(globallyCommonNameAttributes, new GenericArray<>(String.class, 0)));
        tempCommonUiInputsAttributes = excludeAttributes(tempCommonUiInputsAttributes, HelperClass.transformListToArray(commonEventHandlerNameAttributes, new GenericArray<>(String.class, 0)));
        tempCommonUiInputsAttributes = excludeAttributes(tempCommonUiInputsAttributes, HelperClass.transformListToArray(subsetUiInputsNameAttributes, new GenericArray<>(String.class, 0)));
        inputHiddenAttributes.addAll(tempCommonUiInputsAttributes);

        inputHiddenAttributes.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }
}
