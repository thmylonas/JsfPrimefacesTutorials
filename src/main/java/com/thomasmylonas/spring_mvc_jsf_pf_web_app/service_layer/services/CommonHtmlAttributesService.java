package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.ComponentsAttribute;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models.GloballyCommonAttributesFlags;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services._base.AbstractService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "commonHtmlAttributesService")
public class CommonHtmlAttributesService extends AbstractService implements Serializable {

    /**
     * This list contains the globally common Components' attributes.
     * But some components are not having these attributes as they are.
     */
    private List<ComponentsAttribute> globallyCommonAttributesList;

    /**
     * This list contains attributes which are handling events.
     * The policy of this list is to contain ONLY the most common used attributes.
     * All other missing attributes will HAVE TO be added manually.
     * <p>
     * All attributes are the following:
     * "onclick", "ondblclick", "onkeypress", "onkeyup", "onkeydown", "onmouseup", "onmousedown", "onmousemove", "onmouseover",
     * "onmouseout", "onfocus", "onblur", "onselect", "onchange", "onload", "onunload", "onevent", "onerror", "onsubmit", "onreset",
     * "onabort", "onautocomplete", "onautocompleteerror", "oncancel", "oncanplay", "oncanplaythrough", "onclose", "oncontextmenu",
     * "oncuechange", "ondrag", "ondragend", "ondragenter", "ondragexit", "ondragleave", "ondragover", "ondragstart", "ondrop",
     * "ondurationchange", "onemptied", "onended", "oninput", "oninvalid", "onloadeddata", "onloadedmetadata", "onloadstart",
     * "onmouseenter", "onmouseleave", "onmousewheel", "onpause", "onplay", "onplaying", "onprogress", "onratechange", "onresize",
     * "onscroll", "onseeked", "onseeking", "onshow", "onsort", "onstalled", "onsuspend", "ontimeupdate", "ontoggle", "onvolumechange",
     * "onwaiting"
     */
    private List<ComponentsAttribute> commonEventHandlerAttributesList;

    /**
     * This list contains the following attributes: {"dir", "lang", "role", "style", "title"}
     * <p>
     * These attributes are belonging to the following JSF components:
     * "h:body", "h:button", "h:commandButton", "h:commandLink", "h:dataTable", "h:form", "h:graphicImage", "h:inputFile",
     * "h:inputSecret", "h:inputText", "h:inputTextarea", "h:link", "h:message", "h:messages", "h:outputFormat", "h:outputLabel",
     * "h:outputLink", "h:outputText", "h:panelGrid", "h:selectBooleanCheckbox", "h:selectManyCheckbox", "h:selectManyListbox",
     * "h:selectManyMenu", "h:selectOneListbox", "h:selectOneMenu", "h:selectOneRadio"
     */
    private List<ComponentsAttribute> mostCommonAttributesList;

    /**
     * This list contains attributes of components, with which components we can interact clicking on them so they can do a job.
     * This kind of components are: links, buttons, inputs, radio buttons, checkboxes, dropdown menus and others.
     * <p>
     * In JSF these components are:
     * "h:button", "h:commandButton", "h:outputLink", "h:commandLink", "h:link", "h:inputText", "h:inputTextarea", "h:inputFile",
     * "h:inputSecret", "h:selectBooleanCheckbox", "h:selectManyCheckbox", "h:selectManyListbox", "h:selectManyMenu",
     * "h:selectOneListbox", "h:selectOneMenu", "h:selectOneRadio", ["h:outputLabel*"]
     * The "*" means that some attributes are excluded
     */
    private List<ComponentsAttribute> commonInteractAccessAttributesList;

    /**
     * This list contains a small part (subset) of the "UIInput" Components' attributes.
     * (Additionally, this subset is related to the "h:commandButton" - although the 2 last attributes do not even belong here)
     */
    private List<ComponentsAttribute> subsetUiInputsAttributesList;

    /**
     * This list contains the common "UIInput" Components' attributes
     */
    private List<ComponentsAttribute> commonUiInputsAttributesList;

    /**
     * This list contains the common "SelectOne"/"SelectMany" Components' attributes
     */
    private List<ComponentsAttribute> commonSelectsAttributesList;

    /**
     * This list contains the common "Links" Components' attributes
     */
    private List<ComponentsAttribute> commonLinksAttributesList;

    /**
     * This list contains the common "Messages" Components' attributes
     */
    private List<ComponentsAttribute> commonMessagesAttributesList;

    /**
     * This list contains the common "Panels"/"Tables" Components' attributes
     */
    private List<ComponentsAttribute> commonPanelsTablesAttributesList;

    /**
     * This list contains the common "UIOutcomeTarget" Components' attributes
     * The "HtmlOutcomeTargetButton", "HtmlOutcomeTargetLink" which are backing the components "h:button", "h:link",
     * are extended from "UIOutcomeTarget"
     */
    private List<ComponentsAttribute> commonOutcomeTargetsAttributesList;

    @PostConstruct
    private void init() {
        initCommonEventHandlerAttributesList();
        initMostCommonAttributesList();
        initSubsetUiInputsAttributesList();
        initCommonUiInputsAttributesList();
        initCommonLinksAttributesList();
        initCommonMessagesAttributesList();
        initCommonPanelsTablesAttributesList();
        initCommonOutcomeTargetsAttributesList();
        // "globallyCommonAttributesList", "commonInteractAccessAttributesList", "commonSelectsAttributesList" cannot be initialized here
    }

    private void initGloballyCommonAttributesList(GloballyCommonAttributesFlags flags) {

        globallyCommonAttributesList = new ArrayList<>();

        if (flags.isIdAlt) { // Alternative "id" attribute value (The Description is different)
            globallyCommonAttributesList.add(new ComponentsAttribute("id", false, "No default value", "java.lang.String", "The component identifier for the associated component"));
        } else { // Normal "id" attribute value
            globallyCommonAttributesList.add(new ComponentsAttribute("id", false, "No default value", "java.lang.String", "The component identifier for this component. This value must be unique within the closest parent component that is a naming container"));
        }
        if (flags.isValueAlt) { // Alternative "value" attribute value (The Type is different)
            globallyCommonAttributesList.add(new ComponentsAttribute("value", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.Boolean)", "The current value of this component"));
        } else { // Normal "value" attribute value
            globallyCommonAttributesList.add(new ComponentsAttribute("value", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.Object)", "The current value of this component"));
        }
        if (flags.isRenderedAlt) { // Alternative "rendered" attribute value (The Type is different / In the Description the rest is missing)
            globallyCommonAttributesList.add(new ComponentsAttribute("rendered", false, "true", "javax.el.ValueExpression (must evaluate to java.lang.Boolean)", "Flag indicating whether or not this component should be rendered (during Render Response Phase), or processed on any subsequent form submit"));
        } else { // Normal "rendered" attribute value
            globallyCommonAttributesList.add(new ComponentsAttribute("rendered", false, "true", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether or not this component should be rendered (during Render Response Phase), or processed on any subsequent form submit. The default value for this property is true"));
        }
        if (flags.isStyleClassAlt) { // Alternative "styleClass" attribute value (The Description is different in the word "attribute/property")
            globallyCommonAttributesList.add(new ComponentsAttribute("styleClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) to be applied when this element is rendered. This value must be passed through as the 'class' property on generated markup"));
        } else { // Normal "styleClass" attribute value
            globallyCommonAttributesList.add(new ComponentsAttribute("styleClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) to be applied when this element is rendered. This value must be passed through as the 'class' attribute on generated markup"));
        }
        if (flags.isConverterAlt) { // Alternative "converter" attribute value (In the Description the rest is missing)
            globallyCommonAttributesList.add(new ComponentsAttribute("converter", false, "No default value", "javax.el.ValueExpression (must evaluate to javax.faces.convert.Converter)", "Converter instance registered with this component"));
        } else { // Normal "converter" attribute value
            globallyCommonAttributesList.add(new ComponentsAttribute("converter", false, "No default value", "javax.el.ValueExpression (must evaluate to javax.faces.convert.Converter)", "Converter instance registered with this component. As a convenience this attribute is also allowed to evaluate to a java.lang.String, which will be used in a call to Application.createConverter(String converterId) to create the converter instance"));
        }
        if (flags.isBindingAlt) { // Alternative "binding" attribute value (The Description is different)
            globallyCommonAttributesList.add(new ComponentsAttribute("binding", false, "No default value", "javax.el.ValueExpression (must evaluate to javax.faces.component.UIComponent)", "The value binding expression linking this component to a property in a backing bean"));
        } else { // Normal "binding" attribute value
            globallyCommonAttributesList.add(new ComponentsAttribute("binding", false, "No default value", "javax.el.ValueExpression (must evaluate to javax.faces.component.UIComponent)", "The ValueExpression linking this component to a property in a backing bean"));
        }
    }

    private void initCommonEventHandlerAttributesList() {

        commonEventHandlerAttributesList = new ArrayList<>();

        commonEventHandlerAttributesList.add(new ComponentsAttribute("onclick", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a pointer button is clicked over this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("ondblclick", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a pointer button is double clicked over this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onkeypress", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a key is pressed and released over this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onkeyup", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a key is released over this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onkeydown", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a key is pressed down over this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onmouseup", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a pointer button is released over this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onmousedown", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a pointer button is pressed down over this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onmousemove", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a pointer button is moved within this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onmouseover", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a pointer button is moved onto this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onmouseout", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when a pointer button is moved away from this element"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onfocus", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when this element receives focus"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onblur", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when this element loses focus"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onselect", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when text within this element is selected by the user"));
        commonEventHandlerAttributesList.add(new ComponentsAttribute("onchange", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Javascript code executed when this element loses focus and its value has been modified since gaining focus"));
    }

    private void initMostCommonAttributesList() {

        mostCommonAttributesList = new ArrayList<>();

        mostCommonAttributesList.add(new ComponentsAttribute("dir", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Direction indication for text that does not inherit directionality. Valid values are 'LTR' (left-to-right) and 'RTL' (right-to-left). These attributes are case sensitive when rendering to XHTML, so care must be taken to have the correct case"));
        mostCommonAttributesList.add(new ComponentsAttribute("lang", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Code describing the language used in the generated markup for this component"));
        mostCommonAttributesList.add(new ComponentsAttribute("role", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Per the WAI-ARIA spec and its relationship to HTML5 (Section title ARIA Role Attribute), every HTML element may have a 'role' attribute whose value must be passed through unmodified on the element on which it is declared in the final rendered markup. The attribute, if specified, must have a value that is a string literal that is, or an EL Expression that evaluates to, a set of space-separated tokens representing the various WAI-ARIA roles that the element belongs to. It is the page author's responsibility to ensure that the user agent is capable of correctly interpreting the value of this attribute"));
        mostCommonAttributesList.add(new ComponentsAttribute("style", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style(s) to be applied when this component is rendered"));
        mostCommonAttributesList.add(new ComponentsAttribute("title", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Advisory title information about markup elements generated for this component"));
    }

    /**
     * This method initializes the "commonInteractAccessAttributesList".
     * In this list, the attribute "disabled" (based in the following parameter/flag)
     * has alternative value only in the "link" components (e.g. "h:commandLink", "h:link").
     *
     * @param isDisabledAlt The flag: is the value of the attribute "disabled" alternative?
     */
    private void initCommonInteractAccessAttributesList(boolean isDisabledAlt) {

        commonInteractAccessAttributesList = new ArrayList<>();

        commonInteractAccessAttributesList.add(new ComponentsAttribute("accesskey", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Access key that, when pressed, transfers focus to this element"));
        commonInteractAccessAttributesList.add(new ComponentsAttribute("tabindex", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Position of this element in the tabbing order for the current document. This value must be an integer between 0 and 32767"));
        if (isDisabledAlt) { // Alternative "disabled" attribute value (In the Description the rest is missing)
            commonInteractAccessAttributesList.add(new ComponentsAttribute("disabled", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this element must never receive focus or be included in a subsequent submit"));
        } else { // Normal "disabled" attribute value
            commonInteractAccessAttributesList.add(new ComponentsAttribute("disabled", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this element must never receive focus or be included in a subsequent submit. A value of false causes no attribute to be rendered, while a value of true causes the attribute to be rendered as disabled='disabled'"));
        }
    }

    private void initSubsetUiInputsAttributesList() {

        subsetUiInputsAttributesList = new ArrayList<>();

        // The common attributes of the most of the Components
        subsetUiInputsAttributesList.addAll(getMostCommonAttributesList());

        // The attributes of components, with which we can interact
        subsetUiInputsAttributesList.addAll(getCommonInteractAccessAttributesList());

        subsetUiInputsAttributesList.add(new ComponentsAttribute("label", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "A localized user presentable name for this component"));
        subsetUiInputsAttributesList.add(new ComponentsAttribute("readonly", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that this component will prohibit changes by the user. The element may receive focus unless it has also been disabled. A value of false causes no attribute to be rendered, while a value of true causes the attribute to be rendered as readonly='readonly'"));
    }

    private void initCommonUiInputsAttributesList() {

        commonUiInputsAttributesList = new ArrayList<>();

        // The globally common Components' attributes
        commonUiInputsAttributesList.addAll(getGloballyCommonAttributesList());

        // The attributes which are handling events
        commonUiInputsAttributesList.addAll(getCommonEventHandlerAttributesList());

        // The subset of the "UIInput" Components' attributes
        commonUiInputsAttributesList.addAll(getSubsetUiInputsAttributesList());

        commonUiInputsAttributesList.add(new ComponentsAttribute("converterMessage", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "A ValueExpression enabled attribute that, if present, will be used as the text of the converter message, replacing any message that comes from the converter"));
        commonUiInputsAttributesList.add(new ComponentsAttribute("required", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that the user is required to provide a submitted value for this input component"));
        commonUiInputsAttributesList.add(new ComponentsAttribute("requiredMessage", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "A ValueExpression enabled attribute that, if present, will be used as the text of the validation message for the 'required' facility, if the 'required' facility is used"));
        commonUiInputsAttributesList.add(new ComponentsAttribute("validator", false, "No default value", "javax.el.MethodExpression (signature must match void validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object))", "MethodExpression representing a validator method that will be called during Process Validations to perform correctness checks on the value of this component. The expression must evaluate to a public method that takes FacesContext, UIComponent, and Object parameters, with a return type of void. As a convenience this attribute is also allowed to evaluate to a java.lang.String, which will be used in a call to Application.createValidator(String validatorId to create the validator instance"));
        commonUiInputsAttributesList.add(new ComponentsAttribute("validatorMessage", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "A ValueExpression enabled attribute that, if present, will be used as the text of the validator message, replacing any message that comes from the validator"));
        commonUiInputsAttributesList.add(new ComponentsAttribute("valueChangeListener", false, "No default value", "javax.el.MethodExpression (signature must match void valueChange(javax.faces.event.ValueChangeEvent))", "MethodExpression representing a value change listener method that will be notified when a new value has been set for this input component. The expression must evaluate to a public method that takes a ValueChangeEvent parameter, with a return type of void, or to a public method that takes no arguments with a return type of void. In the latter case, the method has no way of easily knowing what the new value is, but this can be useful in cases where a notification is needed that 'this value changed'"));
    }

    /**
     * This method initializes the "commonSelectsAttributesList".
     * In this list, the attributes "enabledClass", "disabledClass" (based in the following parameters/flags)
     * have alternative values only in the "h:selectOneRadio" component.
     *
     * @param isEnabledClassAlt  The flag: is the value of the attribute "enabledClass" alternative?
     * @param isDisabledClassAlt The flag: is the value of the attribute "disabledClass" alternative?
     */
    private void initCommonSelectsAttributesList(boolean isEnabledClassAlt, boolean isDisabledClassAlt) {

        commonSelectsAttributesList = new ArrayList<>();

        // The common "UIInput" Components' attributes
        commonSelectsAttributesList.addAll(getCommonUiInputsAttributesList());

        if (isEnabledClassAlt) { // Alternative "enabledClass" attribute value (The Description has more text)
            commonSelectsAttributesList.add(new ComponentsAttribute("enabledClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to the rendered label on enabled options. This attribute is ignored when 'group' attribute is specified"));
        } else { // Normal "enabledClass" attribute value
            commonSelectsAttributesList.add(new ComponentsAttribute("enabledClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to the rendered label on enabled options"));
        }
        if (isDisabledClassAlt) { // Alternative "disabledClass" attribute value (The Description has more text)
            commonSelectsAttributesList.add(new ComponentsAttribute("disabledClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to the rendered label on disabled options. This attribute is ignored when 'group' attribute is specified"));
        } else { // Normal "disabledClass" attribute value
            commonSelectsAttributesList.add(new ComponentsAttribute("disabledClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to the rendered label on disabled options"));
        }
        commonSelectsAttributesList.add(new ComponentsAttribute("hideNoSelectionOption", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating that, if this component is activated by the user, The 'no selection option', if any, must be hidden"));
    }

    private void initCommonLinksAttributesList() {

        commonLinksAttributesList = new ArrayList<>();

        // The attributes of components, with which we can interact (Alternative attributes: "disabled")
        commonLinksAttributesList.addAll(getCommonInteractAccessAttributesListWithFlags(true));

        commonLinksAttributesList.add(new ComponentsAttribute("target", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Name of a frame where the resource retrieved via this hyperlink is to be displayed"));
        commonLinksAttributesList.add(new ComponentsAttribute("rel", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The relationship from the current document to the anchor specified by this hyperlink. The value of this attribute is a space-separated list of link types"));
        commonLinksAttributesList.add(new ComponentsAttribute("rev", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "A reverse link from the anchor specified by this hyperlink to the current document. The value of this attribute is a space-separated list of link types"));
        commonLinksAttributesList.add(new ComponentsAttribute("type", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The content type of the resource designated by this hyperlink"));
        commonLinksAttributesList.add(new ComponentsAttribute("charset", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The character encoding of the resource designated by this hyperlink"));
        commonLinksAttributesList.add(new ComponentsAttribute("hreflang", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The language code of the resource designated by this hyperlink"));
        commonLinksAttributesList.add(new ComponentsAttribute("coords", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The position and shape of the hot spot on the screen (for use in client-side image maps)"));
        commonLinksAttributesList.add(new ComponentsAttribute("shape", false, "default (entire region)", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The shape of the hot spot on the screen (for use in client-side image maps). Valid values are: default (entire region); rect (rectangular region); circle (circular region); and poly (polygonal region)"));
    }

    private void initCommonMessagesAttributesList() {

        commonMessagesAttributesList = new ArrayList<>();

        commonMessagesAttributesList.add(new ComponentsAttribute("tooltip", false, "No default value", "javax.el.ValueExpression (must evaluate to boolean)", "Flag indicating whether the detail portion of the message should be displayed as a tooltip"));
        commonMessagesAttributesList.add(new ComponentsAttribute("infoClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to any message with a severity class of 'INFO'"));
        commonMessagesAttributesList.add(new ComponentsAttribute("infoStyle", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style(s) to apply to any message with a severity class of 'INFO'"));
        commonMessagesAttributesList.add(new ComponentsAttribute("warnClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to any message with a severity class of 'WARN'"));
        commonMessagesAttributesList.add(new ComponentsAttribute("warnStyle", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style(s) to apply to any message with a severity class of 'WARN'"));
        commonMessagesAttributesList.add(new ComponentsAttribute("errorClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to any message with a severity class of 'ERROR'"));
        commonMessagesAttributesList.add(new ComponentsAttribute("errorStyle", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style(s) to apply to any message with a severity class of 'ERROR'"));
        commonMessagesAttributesList.add(new ComponentsAttribute("fatalClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style class to apply to any message with a severity class of 'FATAL'"));
        commonMessagesAttributesList.add(new ComponentsAttribute("fatalStyle", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style(s) to apply to any message with a severity class of 'FATAL'"));
    }

    private void initCommonPanelsTablesAttributesList() {

        commonPanelsTablesAttributesList = new ArrayList<>();

        commonPanelsTablesAttributesList.add(new ComponentsAttribute("headerClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to any header generated for this table"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("footerClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to any footer generated for this table"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("rowClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Assigns one or more space-separated CSS class names to each 'tr'"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("rowClasses", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Comma-delimited list of CSS style classes that will be applied to the rows of this table. A space separated list of classes may also be specified for any individual row. The styles are applied, in turn, to each row in the table. For example, if the list has two elements, the first style class in the list is applied to the first row, the second to the second row, the first to the third row, the second to the fourth row, etc. In other words, we keep iterating through the list until we reach the end, and then we start at the beginning again"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("columnClasses", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Comma-delimited list of CSS style classes that will be applied to the columns of this table. A space separated list of classes may also be specified for any individual column. If the number of elements in this list is less than the number of actual column children of the UIData, no 'class' attribute is output for each column greater than the number of elements in the list. If the number of elements in the list is greater than the number of actual column children of the UIData, the elements at the position in the list after the last column are ignored"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("width", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Width of the entire table, for visual user agents"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("bodyrows", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Comma separated list of row indices for which a new 'tbody' element should be started (and any previously opened one should be ended)"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("cellpadding", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Definition of how much space the user agent should leave between the border of each cell and its contents"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("cellspacing", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Definition of how much space the user agent should leave between the left side of the table and the leftmost column, the top of the table and the top of the top side of the topmost row, and so on for the right and bottom of the table. It also specifies the amount of space to leave between cells"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("frame", false, "none (no sides)", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Code specifying which sides of the frame surrounding this table will be visible. Valid values are: none (no sides, default value); above (top side only); below (bottom side only); hsides (top and bottom sides only); vsides (right and left sides only); lhs (left hand side only); rhs (right hand side only); box (all four sides); and border (all four sides)"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("border", false, "No default value", "javax.el.ValueExpression (must evaluate to int)", "Width (in pixels) of the border to be drawn around this table"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("bgcolor", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Name or code of the background color for this table"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("captionClass", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Space-separated list of CSS style class(es) that will be applied to any caption generated for this table"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("captionStyle", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "CSS style(s) to be applied when this caption is rendered"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("summary", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Summary of this table's purpose and structure, for user agents rendering to non-visual media such as speech and Braille"));
        commonPanelsTablesAttributesList.add(new ComponentsAttribute("rules", false, "none (no rules)", "javax.el.ValueExpression (must evaluate to java.lang.String)", "Code specifying which rules will appear between cells within this table. Valid values are: none (no rules, default value); groups (between row groups); rows (between rows only); cols (between columns only); and all (between all rows and columns)"));
    }

    private void initCommonOutcomeTargetsAttributesList() {

        commonOutcomeTargetsAttributesList = new ArrayList<>();

        commonOutcomeTargetsAttributesList.add(new ComponentsAttribute("outcome", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The logical outcome used to resolve a navigation case"));
        commonOutcomeTargetsAttributesList.add(new ComponentsAttribute("fragment", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.String)", "The identifier of the page fragment which should be brought into focus when the target page is rendered. The value of this attribute is appended to the end of target URL following a hash (#) mark. This notation is part of the standard URL syntax"));
        commonOutcomeTargetsAttributesList.add(new ComponentsAttribute("includeViewParams", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.Boolean)", "Whether to include page parameters in the target URI"));
        commonOutcomeTargetsAttributesList.add(new ComponentsAttribute("disableClientWindow", false, "No default value", "javax.el.ValueExpression (must evaluate to java.lang.Boolean)", "Disable appending the ClientWindow on the rendering of this element"));
    }

    public List<ComponentsAttribute> getGloballyCommonAttributesListWithFlags(GloballyCommonAttributesFlags globallyCommonAttributesFlags) {
        initGloballyCommonAttributesList(globallyCommonAttributesFlags);
        return globallyCommonAttributesList;
    }

    public List<ComponentsAttribute> getGloballyCommonAttributesList() {
        return getGloballyCommonAttributesListWithFlags(
                new GloballyCommonAttributesFlags.Builder()
                        .isIdAlt(false)
                        .isValueAlt(false)
                        .isRenderedAlt(false)
                        .isStyleClassAlt(false)
                        .isConverterAlt(false)
                        .isBindingAlt(false)
                        .build());
    }

    public List<ComponentsAttribute> getCommonEventHandlerAttributesList() {
        return commonEventHandlerAttributesList;
    }

    public List<ComponentsAttribute> getMostCommonAttributesList() {
        return mostCommonAttributesList;
    }

    public List<ComponentsAttribute> getCommonInteractAccessAttributesListWithFlags(boolean isDisabledAlt) {
        initCommonInteractAccessAttributesList(isDisabledAlt);
        return commonInteractAccessAttributesList;
    }

    public List<ComponentsAttribute> getCommonInteractAccessAttributesList() {
        return getCommonInteractAccessAttributesListWithFlags(false);
    }

    public List<ComponentsAttribute> getSubsetUiInputsAttributesList() {
        return subsetUiInputsAttributesList;
    }

    public List<ComponentsAttribute> getCommonUiInputsAttributesList() {
        return commonUiInputsAttributesList;
    }

    public List<ComponentsAttribute> getCommonSelectsAttributesListWithFlags(boolean isEnabledClassAlt, boolean isDisabledClassAlt) {
        initCommonSelectsAttributesList(isEnabledClassAlt, isDisabledClassAlt);
        return commonSelectsAttributesList;
    }

    public List<ComponentsAttribute> getCommonSelectsAttributesList() {
        return getCommonSelectsAttributesListWithFlags(false, false);
    }

    public List<ComponentsAttribute> getCommonLinksAttributesList() {
        return commonLinksAttributesList;
    }

    public List<ComponentsAttribute> getCommonMessagesAttributesList() {
        return commonMessagesAttributesList;
    }

    public List<ComponentsAttribute> getCommonPanelsTablesAttributesList() {
        return commonPanelsTablesAttributesList;
    }

    public List<ComponentsAttribute> getCommonOutcomeTargetsAttributesList() {
        return commonOutcomeTargetsAttributesList;
    }
}
