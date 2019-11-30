package com.thomasmylonas.my_spring_hibernate_jsf_web_app._tutorial.multiple_resolvers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(path = "/")
public class MultipleResolversController implements WebMvcConfigurer {
    //    @RequestMapping(method = RequestMethod.GET, produces = "text/xhtml")

    @RequestMapping(path = "multi", method = RequestMethod.GET)
    public String getMulti() {
        return "multi";
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
