package com.thomasmylonas.my_spring_hibernate_jsf_web_app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Configuration
@ComponentScan(basePackages = {"com.thomasmylonas.my_spring_hibernate_jsf_web_app"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
        }
)
public class RootConfig {
}
