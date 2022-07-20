package com.thomasmylonas.spring_mvc_jsf_pf_web_app.servlet_dispatcher_web_components.views_filters._base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public abstract class AbstractViewsFilter implements Filter {

    protected final Logger LOGGER = LogManager.getLogger(getClass().getName());
    @SuppressWarnings("all")
    private final String MAIN_VIEWS_DIR = "/views";
    @SuppressWarnings("all")
    private final String SPECIAL_LAST_URI_PART = "home";

    protected final String MAIN_PAGES_LEVEL_1_DIR = "/pages_level_1/";
    protected final String MAIN_SPRING_FRAMEWORK_DIR = "/pages_level_2/spring_framework/";
    protected final String MAIN_JSF_DIR = "/pages_level_2/jsf/";
    protected final String MAIN_PRIMEFACES_DIR = "/pages_level_2/primefaces/";
    protected final String MAIN_JSF_H_TAGLIB_DIR = "/pages_level_2/jsf/jsf_h_taglib/";
    protected final String MAIN_JSF_TRICKS_OTHERS_DIR = "/pages_level_2/jsf/_jsf_tricks_others/";

    public void doFilter(String parentDirPath, Class<?> filterSubClass, ServletRequest request,
                         ServletResponse response, @SuppressWarnings("unused") FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // About the request URI the client types
        String relativeRequestUri = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        String lastUriPart = extractLastUriPart(relativeRequestUri);

        String pageFullRealPath = getPageFullRealPath(parentDirPath, filterSubClass, lastUriPart);

        if (pageFullRealPath != null) {
            httpRequest.getRequestDispatcher(pageFullRealPath).forward(httpRequest, httpResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    private String extractLastUriPart(String relativeRequestUri) {
        return relativeRequestUri.substring(relativeRequestUri.lastIndexOf("/") + 1);
    }

    private String getPageFullRealPath(String parentDirPath, Class<?> filterSubClass, String lastUriPart) {

        String result = null;
        String[] webFilterPathPatterns = new String[0];
        try {
            webFilterPathPatterns = getWebFilterPathPatterns(filterSubClass);
            if (webFilterPathPatterns == null) {
                return null;
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            LOGGER.error("'HelperClass::getWebFilterPathPatterns' throws 'InvocationTargetException,IllegalAccessException'");
        }

        if (lastUriPart.equals("")) {
            lastUriPart = SPECIAL_LAST_URI_PART;
        }
        for (String webFilterPathPattern : webFilterPathPatterns) {
            if (webFilterPathPattern.contains(lastUriPart)) {
                result = MAIN_VIEWS_DIR + parentDirPath + lastUriPart.replace("-", "_") + ".xhtml";
                break;
            }
        }
        return result;
    }

    /**
     * This method gets all the WebFilter path patterns for mapping
     *
     * @param clazz The SubClass of the filter
     * @return The WebFilter path patterns for mapping
     * @throws InvocationTargetException "Method::invoke" throws "InvocationTargetException"
     * @throws IllegalAccessException    "Method::invoke" throws "IllegalAccessException"
     */
    public static String[] getWebFilterPathPatterns(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {

        if (clazz == null) {
            return null;
        }
        Annotation annotation = clazz.getAnnotations()[0];
        Class<? extends Annotation> annotationType = annotation.annotationType();

        Method valueMethod = Stream.of(annotationType.getDeclaredMethods())
                .filter(method -> method.getName().equalsIgnoreCase("value"))
                .findAny().orElse(null);
        return valueMethod == null ? null : (String[]) valueMethod.invoke(annotation, null);
    }
}
