package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services._base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractService {
    protected final Logger LOGGER = LogManager.getLogger(getClass().getName());
}
