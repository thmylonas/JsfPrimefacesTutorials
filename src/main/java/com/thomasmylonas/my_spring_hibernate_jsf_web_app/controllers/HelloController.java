package com.thomasmylonas.my_spring_hibernate_jsf_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(path = "/")
public class HelloController implements WebMvcConfigurer {
    //    @RequestMapping(method = RequestMethod.GET, produces = "text/xhtml")

    @RequestMapping(path = "a/s", method = RequestMethod.GET)
    public String getHello() {
//        return "/WEB-INF/views/hello.xhtml";
        return "hello";
    }

    @RequestMapping(path = "a/i", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

//    @RequestMapping(path = "/", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public String getMainApp() {
        return "index";
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
