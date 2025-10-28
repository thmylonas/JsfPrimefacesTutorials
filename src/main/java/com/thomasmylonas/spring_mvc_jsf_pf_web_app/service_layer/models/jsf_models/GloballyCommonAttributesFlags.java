package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models.jsf_models;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base.AbstractModel;

/**
 * This class contains all the flags which decide if
 * the "globallyCommonAttributes" ("id", "value", "rendered", "styleClass", "converter", "binding")
 * have alternative values.
 *
 * @author Thomas_Mylonas
 * @since 16-Mar-2021
 */
public final class GloballyCommonAttributesFlags extends AbstractModel {

    /**
     * The flag: is the value of the attribute "id" alternative?
     */
    public boolean isIdAlt;

    /**
     * The flag: is the value of the attribute "value" alternative?
     */
    public boolean isValueAlt;

    /**
     * The flag: is the value of the attribute "rendered" alternative?
     */
    public boolean isRenderedAlt;

    /**
     * The flag: is the value of the attribute "styleClass" alternative?
     */
    public boolean isStyleClassAlt;

    /**
     * The flag: is the value of the attribute "converter" alternative?
     */
    public boolean isConverterAlt;

    /**
     * The flag: is the value of the attribute "binding" alternative?
     */
    public boolean isBindingAlt;

    /**
     * The constructor has to be private, so the objects will be created via the builder
     *
     * @param isIdAlt         The flag: is the value of the attribute "id" alternative?
     * @param isValueAlt      The flag: is the value of the attribute "value" alternative?
     * @param isRenderedAlt   The flag: is the value of the attribute "rendered" alternative?
     * @param isStyleClassAlt The flag: is the value of the attribute "styleClass" alternative?
     * @param isConverterAlt  The flag: is the value of the attribute "converter" alternative?
     * @param isBindingAlt    The flag: is the value of the attribute "binding" alternative?
     */
    @Deprecated
    private GloballyCommonAttributesFlags(boolean isIdAlt, boolean isValueAlt, boolean isRenderedAlt,
                                          boolean isStyleClassAlt, boolean isConverterAlt, boolean isBindingAlt) {
        this.isIdAlt = isIdAlt;
        this.isValueAlt = isValueAlt;
        this.isRenderedAlt = isRenderedAlt;
        this.isStyleClassAlt = isStyleClassAlt;
        this.isConverterAlt = isConverterAlt;
        this.isBindingAlt = isBindingAlt;
    }

    /**
     * The constructor has to be private, so the objects will be created via the builder
     *
     * @param builder The builder for this class
     */
    private GloballyCommonAttributesFlags(Builder builder) {
        this.isIdAlt = builder.isIdAlt;
        this.isValueAlt = builder.isValueAlt;
        this.isRenderedAlt = builder.isRenderedAlt;
        this.isStyleClassAlt = builder.isStyleClassAlt;
        this.isConverterAlt = builder.isConverterAlt;
        this.isBindingAlt = builder.isBindingAlt;
    }

    public static class Builder {

        private boolean isIdAlt;
        private boolean isValueAlt;
        private boolean isRenderedAlt;
        private boolean isStyleClassAlt;
        private boolean isConverterAlt;
        private boolean isBindingAlt;

        public Builder isIdAlt(boolean isIdAlt) {
            this.isIdAlt = isIdAlt;
            return this;
        }

        public Builder isValueAlt(boolean isValueAlt) {
            this.isValueAlt = isValueAlt;
            return this;
        }

        public Builder isRenderedAlt(boolean isRenderedAlt) {
            this.isRenderedAlt = isRenderedAlt;
            return this;
        }

        public Builder isStyleClassAlt(boolean isStyleClassAlt) {
            this.isStyleClassAlt = isStyleClassAlt;
            return this;
        }

        public Builder isConverterAlt(boolean isConverterAlt) {
            this.isConverterAlt = isConverterAlt;
            return this;
        }

        public Builder isBindingAlt(boolean isBindingAlt) {
            this.isBindingAlt = isBindingAlt;
            return this;
        }

        public GloballyCommonAttributesFlags build() {
            /*
            // This is another way to initialize the class's variables (Deprecated way)
            return new GloballyCommonAttributesFlags(isIdAlt, isValueAlt, isRenderedAlt, isStyleClassAlt, isConverterAlt, isBindingAlt);
            */
            return new GloballyCommonAttributesFlags(this);
        }
    }
}
