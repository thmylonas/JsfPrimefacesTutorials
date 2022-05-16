package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services._base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractService {
    protected final Logger LOGGER = LogManager.getLogger(getClass().getName());
}
