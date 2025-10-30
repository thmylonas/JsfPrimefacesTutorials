package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models.jsf_models;

import lombok.Builder;

/**
 * This record contains all the flags which decide if
 * the "globallyCommonAttributes" ("id", "value", "rendered", "styleClass", "converter", "binding")
 * have alternative values.
 *
 * @author Thomas_Mylonas
 * @since 16-Mar-2021
 */
@Builder
public record GloballyCommonAttributesFlags(

        // The flag: is the value of the attribute "id" alternative?
        boolean idAlt,

        // The flag: is the value of the attribute "value" alternative?
        boolean valueAlt,

        // The flag: is the value of the attribute "rendered" alternative?
        boolean renderedAlt,

        // The flag: is the value of the attribute "styleClass" alternative?
        boolean styleClassAlt,

        // The flag: is the value of the attribute "converter" alternative?
        boolean converterAlt,

        // The flag: is the value of the attribute "binding" alternative?
        boolean bindingAlt
) {
}
