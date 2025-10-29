package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;

public abstract class AbstractBackingBean implements Serializable {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractBackingBean.class.getSimpleName());

    // Constants of directories of Properties files
    protected static final String PROPERTIES_FILE_1_DIR = "resource_bundles/messages.properties";

    // Constants of styling
    protected static final String SPAN_OPEN_LEFT_STYLE = "<span style=\"";
    protected static final String SPAN_OPEN_RIGHT_STYLE = "\">";
    protected static final String SPAN_CLOSE = "</span>";
    protected static final String ATTR_COLON = "; ";
    protected static final String COLOR_ATTR = "color:";
    protected static final String FONT_WEIGHT_ATTR = "font-weight:";

    // Constants of colors
    protected final String COLOR_BLUE = fetchPropertyValueFromProperties(PROPERTIES_FILE_1_DIR, "color.blue", "The 'color.blue' is not found!");
    protected final String COLOR_DEEP_PINK = fetchPropertyValueFromProperties(PROPERTIES_FILE_1_DIR, "color.deep_pink", "The 'color.deep_pink' is not found!");

    protected String fetchPropertyValueFromProperties(String propertiesPath, String propertyName, String errorMessage) {

        String propertyValue = "No '" + propertyName + "' value found!";
        try {
            propertyValue = HelperClass.fetchPropertyValueFromProperties(propertiesPath, propertyName);
        } catch (IOException e) {
            LOGGER.error("@@@ In 'AbstractBackingBean': " + errorMessage +
                    " (because 'HelperClass::getPropertyValueFromProperties' throws 'IOException') @@@");
        }
        return propertyValue;
    }

    protected String highlightingSpan(String spanText, String color, String weight) {
        return SPAN_OPEN_LEFT_STYLE + COLOR_ATTR + color + ATTR_COLON + FONT_WEIGHT_ATTR + weight + SPAN_OPEN_RIGHT_STYLE +
                spanText + SPAN_CLOSE;
    }
}
