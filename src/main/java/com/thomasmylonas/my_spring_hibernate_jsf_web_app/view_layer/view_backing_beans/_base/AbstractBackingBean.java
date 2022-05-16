package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans._base;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
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
}
