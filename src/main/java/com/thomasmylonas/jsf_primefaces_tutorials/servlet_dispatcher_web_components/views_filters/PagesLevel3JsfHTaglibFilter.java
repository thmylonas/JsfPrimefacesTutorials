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
                "/facelets/jsf-h-head/*",
                "/facelets/jsf-h-body/*",
                "/facelets/jsf-h-output-text/*",
                "/facelets/jsf-h-output-label/*",
                "/facelets/jsf-h-output-format/*",
                "/facelets/jsf-h-input-text/*",
                "/facelets/jsf-h-input-text-area/*",
                "/facelets/jsf-h-input-secret/*",
                "/facelets/jsf-h-input-hidden/*",
                "/facelets/jsf-h-input-file/*",
                "/facelets/jsf-h-command-button/*",
                "/facelets/jsf-h-button/*",
                "/facelets/jsf-h-output-link/*",
                "/facelets/jsf-h-command-link/*",
                "/facelets/jsf-h-link/*",
                "/facelets/jsf-h-select-one-listbox/*",
                "/facelets/jsf-h-select-one-menu/*",
                "/facelets/jsf-h-select-one-radio/*",
                "/facelets/jsf-h-select-boolean-checkbox/*",
                "/facelets/jsf-h-select-many-checkbox/*",
                "/facelets/jsf-h-select-many-listbox/*",
                "/facelets/jsf-h-select-many-menu/*",
                "/facelets/jsf-h-panel-group/*",
                "/facelets/jsf-h-form/*",
                "/facelets/jsf-h-column/*",
                "/facelets/jsf-h-panel-grid/*",
                "/facelets/jsf-h-data-table/*",
                "/facelets/jsf-h-graphic-image/*",
                "/facelets/jsf-h-message/*",
                "/facelets/jsf-h-messages/*",
                "/facelets/jsf-h-doctype/*",
                "/facelets/jsf-h-output-stylesheet/*",
                "/facelets/jsf-h-output-script/*",
                "/facelets/jsf-h-command-script/*",
        }
)
public class PagesLevel3JsfHTaglibFilter extends AbstractViewsFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(MAIN_JSF_H_TAGLIB_DIR, this.getClass(), request, response, filterChain);
    }
}
