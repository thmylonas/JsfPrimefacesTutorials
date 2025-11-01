package com.thomasmylonas.jsf_primefaces_tutorials.servlet_dispatcher_web_components.views_filters;

import com.thomasmylonas.jsf_primefaces_tutorials.servlet_dispatcher_web_components.views_filters._base.AbstractViewsFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        value = {
                "/",
                "/facelets/home/*",
                "/facelets/jsf/*",
                "/facelets/primefaces/*",
                "/facelets/jsf-jpa/*",
                "/facelets/about/*"
        }
)
public class PagesLevel1Filter extends AbstractViewsFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(MAIN_PAGES_LEVEL_1_DIR, this.getClass(), request, response, filterChain);
    }
}
