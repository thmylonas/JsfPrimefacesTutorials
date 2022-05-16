package com.thomasmylonas.my_spring_hibernate_jsf_web_app.servlet_dispatcher_web_components.views_filters;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.servlet_dispatcher_web_components.views_filters._base.AbstractViewsFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        value = {
                "/facelets/jsf-h-taglib/*"
        }
)
public class PagesLevel2JsfFilter extends AbstractViewsFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(MAIN_JSF_DIR, this.getClass(), request, response, filterChain);
    }
}
