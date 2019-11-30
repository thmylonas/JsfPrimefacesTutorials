package com.thomasmylonas.my_spring_hibernate_jsf_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(path = "/")
public class OtherController implements WebMvcConfigurer {
    //    @RequestMapping(method = RequestMethod.GET, produces = "text/xhtml")

    @RequestMapping(path = "other", method = RequestMethod.GET)
    public String getMainApp() {
        return "other";
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
