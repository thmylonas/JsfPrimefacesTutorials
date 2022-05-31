package com.thomasmylonas.my_spring_hibernate_jsf_web_app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.thomasmylonas.my_spring_hibernate_jsf_web_app"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com\\.thomasmylonas\\.my_spring_hibernate_jsf_web_app\\.data_access_layer\\..*"}),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"com\\.thomasmylonas\\.my_spring_hibernate_jsf_web_app\\.servlet_dispatcher_web_components\\..*"}),
        }
)
public class RootConfig {
}
