package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.jsf_backing_beans.pages_level_ge2_backing_beans.h_taglib_backing_beans.h_selects_backing_beans._base.AbstractHtmlSelectOneBackingBean;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "htmlSelectOneListboxBackingBean")
@Getter
public class HtmlSelectOneListboxBackingBean extends AbstractHtmlSelectOneBackingBean {

    private List<ComponentsAttribute> selectOneListboxAttributes;

    @PostConstruct
    private void init() {
        initComponentsAttributes();
        initExamplesValues();
        initSelectItemsWithMapsAndArrays();
    }

    private void initComponentsAttributes() {

        selectOneListboxAttributes = new ArrayList<>();

        // The common "SelectOne"/"SelectMany" Components' attributes
        selectOneListboxAttributes.addAll(commonHtmlAttributesService.initAndGetCommonSelectsAttributes());

        selectOneListboxAttributes.add(new ComponentsAttribute("size", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Number of available options to be shown at all times. If not specified, all available options are shown"));
    }
}
