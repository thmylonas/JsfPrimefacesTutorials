package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public abstract class AbstractModel {

    protected final Logger LOGGER = LogManager.getLogger(getClass().getName());
    // Constants of directories of Properties files
    protected final String PROPERTIES_FILE_1_DIR = "resource_bundles/messages.properties";
    // Other constants
    protected final String WEBAPP_LINK = getPropertyValueFromProperties(PROPERTIES_FILE_1_DIR, "webapp_link", "The 'webapp_link' is not found!");

    protected String getPropertyValueFromProperties(@SuppressWarnings("all") String propertiesPath,
                                                    @SuppressWarnings("all") String propertyName,
                                                    @SuppressWarnings("all") String errorMessage) {

        String propertyValue = "No '" + propertyName + "' value found!";
        try {
            propertyValue = HelperClass.getPropertyValueFromProperties(propertiesPath, propertyName);
        } catch (IOException e) {
            LOGGER.error("@@@ In 'AbstractModel': " + errorMessage +
                    " (because 'HelperClass::getPropertyValueFromProperties' throws 'IOException') @@@");
        }
        return propertyValue;
    }
}
