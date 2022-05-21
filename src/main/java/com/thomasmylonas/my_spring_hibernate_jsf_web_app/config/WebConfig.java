package com.thomasmylonas.my_spring_hibernate_jsf_web_app.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = {"com.thomasmylonas.my_spring_hibernate_jsf_web_app"})
@EnableWebMvc
public class WebConfig {

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
        viewResolver.setOrder(100); // InternalResourceViewResolver - lowest priority
        //viewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class); // Error1 - Code: 500
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }

    /**
     * This method replaces fully the configuration in "web.xml"
     *
     * @param servletContext The ServletContext
     * @return The ServletRegistrationBean
     */
    //@Bean
    ServletRegistrationBean<FacesServlet> facesServletRegistration(ServletContext servletContext) {

        // Spring Boot works only, if this is set
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
        // Use JSF view templates saved as *.xhtml, for use with Facelets
        servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
        servletContext.setInitParameter("javax.faces.CONFIG_FILES", "/WEB-INF/faces-config.xml");

        // This parameter enables better error messages, including in the client-side JavaScript, at the cost of some performance
        //servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
        // State saving method: 'client' or 'server' (=default)
        //servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "client");

        // FacesServlet registration
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new FacesServlet());
        servletRegistrationBean.setUrlMappings(Arrays.asList("*.xhtml", "*.jsf", "/faces/*", "*.faces"));
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
}
