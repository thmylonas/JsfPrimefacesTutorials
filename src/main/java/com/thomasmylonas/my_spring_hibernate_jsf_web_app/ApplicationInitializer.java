package com.thomasmylonas.my_spring_hibernate_jsf_web_app;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app._tutorial.multiple_resolvers.MultipleResolversConfig;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.config.DataAccessConfig;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.config.RootConfig;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, DataAccessConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class, MultipleResolversConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
