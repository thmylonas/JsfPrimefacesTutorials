package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.models._base;

import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public abstract class AbstractModel {

    // Constants of directories of Properties files
    protected static final String PROPERTIES_FILE_1_DIR = "resource_bundles/messages.properties";

    // Other constants
    protected final String WEBAPP_LINK = fetchPropertyValueFromProperties(PROPERTIES_FILE_1_DIR, "webapp_link", "The 'webapp_link' is not found!");

    protected String fetchPropertyValueFromProperties(String propertiesPath, String propertyName, String errorMessage) {

        String propertyValue = "No '" + propertyName + "' value found!";
        try {
            propertyValue = HelperClass.fetchPropertyValueFromProperties(propertiesPath, propertyName); // IOException
        } catch (IOException e) {
            log.error("In 'AbstractModel': {} (because 'HelperClass::fetchPropertyValueFromProperties' throws 'IOException')", errorMessage);
        }
        return propertyValue;
    }
}
