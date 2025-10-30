package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models.GenericArray;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_inputs_backing_beans._base.AbstractHtmlInputsBackingBean;
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

    private List<ComponentsAttribute> inputHiddenAttributesList;

    @PostConstruct
    private void init() {
        initCommonHtmlInputsAttributes();
        initComponentsAttributesList();
    }

    private void initComponentsAttributesList() {

        inputHiddenAttributesList = new ArrayList<>();

        // The globally common Components' attributes (Containing attributes: "id", "value", "rendered", "converter", "binding")
        inputHiddenAttributesList.addAll(excludeAttributes(commonHtmlAttributesService.initAndGetGloballyCommonAttributesList(), EXCLUDED_GLOBALLY_COMMON_ATTRIBUTES));

        // The common "UIInput" Components' attributes
        List<String> globallyCommonNameAttributesList = commonHtmlAttributesService.initAndGetGloballyCommonAttributesList().stream().map(ComponentsAttribute::getName).collect(Collectors.toList());
        List<String> commonEventHandlerNameAttributesList = commonHtmlAttributesService.getCommonEventHandlerAttributesList().stream().map(ComponentsAttribute::getName).collect(Collectors.toList());
        List<String> subsetUiInputsNameAttributesList = commonHtmlAttributesService.getSubsetUiInputsAttributesList().stream().map(ComponentsAttribute::getName).collect(Collectors.toList());
        List<ComponentsAttribute> tempCommonUiInputsAttributesList = excludeAttributes(commonHtmlAttributesService.getCommonUiInputsAttributesList(), HelperClass.transformListToArray(globallyCommonNameAttributesList, new GenericArray<>(String.class, 0)));
        tempCommonUiInputsAttributesList = excludeAttributes(tempCommonUiInputsAttributesList, HelperClass.transformListToArray(commonEventHandlerNameAttributesList, new GenericArray<>(String.class, 0)));
        tempCommonUiInputsAttributesList = excludeAttributes(tempCommonUiInputsAttributesList, HelperClass.transformListToArray(subsetUiInputsNameAttributesList, new GenericArray<>(String.class, 0)));
        inputHiddenAttributesList.addAll(tempCommonUiInputsAttributesList);

        inputHiddenAttributesList.add(new ComponentsAttribute("immediate", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component's value must be converted and validated immediately (that is, during Apply Request Values phase), rather than waiting until Process Validations phase"));
    }
}
