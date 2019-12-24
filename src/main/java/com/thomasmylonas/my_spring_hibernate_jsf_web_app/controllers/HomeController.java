package com.thomasmylonas.my_spring_hibernate_jsf_web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(path = "/")
public class HomeController implements WebMvcConfigurer {
    //    @RequestMapping(method = RequestMethod.GET, produces = "text/xhtml")

//    @RequestMapping(path = {"home", "/"}, method = RequestMethod.GET)
    @RequestMapping(path = {"home"}, method = RequestMethod.GET)
    public String getHome() {
//        return "/WEB-INF/views/home.xhtml";
        return "home";
    }

    @RequestMapping(path = "home/student", method = RequestMethod.GET)
    public String getJava() {
        return "student";
    }

//    @RequestMapping(path = "/", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public String getMainApp() {
        return "home";
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
