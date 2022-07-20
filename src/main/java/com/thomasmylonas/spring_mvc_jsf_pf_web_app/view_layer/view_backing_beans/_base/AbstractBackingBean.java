package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;

public abstract class AbstractBackingBean implements Serializable {

    protected final Logger LOGGER = LogManager.getLogger(getClass().getName());
    // Constants of directories of Properties files
    protected final String PROPERTIES_FILE_1_DIR = "resource_bundles/messages.properties";
    // Constants of colors
    protected final String COLOR_BLUE = getPropertyValueFromProperties(PROPERTIES_FILE_1_DIR, "color.blue", "The 'color.blue' is not found!");
    protected final String COLOR_DEEP_PINK = getPropertyValueFromProperties(PROPERTIES_FILE_1_DIR, "color.deep_pink", "The 'color.deep_pink' is not found!");
    // Constants of styling
    protected final String SPAN_OPEN_LEFT_STYLE = "<span style=\"";
    protected final String SPAN_OPEN_RIGHT_STYLE = "\">";
    protected final String SPAN_CLOSE = "</span>";
    protected final String ATTR_COLON = "; ";
    protected final String COLOR_ATTR = "color:";
    protected final String FONT_WEIGHT_ATTR = "font-weight:";

    protected String getPropertyValueFromProperties(@SuppressWarnings("all") String propertiesPath, String propertyName,
                                                    @SuppressWarnings("all") String errorMessage) {

        String propertyValue = "No '" + propertyName + "' value found!";
        try {
            propertyValue = HelperClass.getPropertyValueFromProperties(propertiesPath, propertyName);
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
