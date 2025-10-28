package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class AbstractModel {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractModel.class.getSimpleName());

    // Constants of directories of Properties files
    protected final String PROPERTIES_FILE_1_DIR = "resource_bundles/messages.properties";
    // Other constants
    protected final String WEBAPP_LINK = getPropertyValueFromProperties(PROPERTIES_FILE_1_DIR, "webapp_link", "The 'webapp_link' is not found!");

    protected String getPropertyValueFromProperties(String propertiesPath, String propertyName, String errorMessage) {

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
