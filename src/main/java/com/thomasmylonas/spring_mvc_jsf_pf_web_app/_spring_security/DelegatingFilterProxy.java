package com.thomasmylonas.spring_mvc_jsf_pf_web_app._spring_security;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * This class is made by me, without the help of any tutorial.
 * This code, might not be correct
 */
@WebFilter(value = {"/"})
public class DelegatingFilterProxy implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    }
}
