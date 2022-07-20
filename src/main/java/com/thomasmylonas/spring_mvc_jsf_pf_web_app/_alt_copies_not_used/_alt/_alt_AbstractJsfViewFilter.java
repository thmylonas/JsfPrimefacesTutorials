package com.thomasmylonas.spring_mvc_jsf_pf_web_app._alt_copies_not_used._alt;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unused")
public abstract class _alt_AbstractJsfViewFilter implements Filter {

    protected boolean resourceExists;
    protected boolean facesResourceRequest;
    protected HttpServletRequest httpRequest;
    protected HttpServletResponse httpResponse;

    public void doFilter(String path, ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;
        String relativeRequestUri = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        // Check if the resource with the "relativeRequestUri" can be found
        resourceExists = httpRequest.getServletContext().getResource(relativeRequestUri) != null;
        // httpRequest.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER == "/MyWebsiteWebApp/javax.faces.resource", ResourceHandler.RESOURCE_IDENTIFIER == "/javax.faces.resource"
        facesResourceRequest = httpRequest.getRequestURI().startsWith(httpRequest.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        if (resourceExists || facesResourceRequest) {
            filterChain.doFilter(httpRequest, httpResponse);
        } else { // If the resource with the "relativeRequestUri" cannot be found
            httpRequest.getRequestDispatcher(path).forward(httpRequest, httpResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
