package com.thomasmylonas.jsf_primefaces_tutorials.servlet_dispatcher_web_components.views_filters._base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractViewsFilter.class.getSimpleName());

    private static final String MAIN_VIEWS_DIR = "/views";
    private static final String SPECIAL_LAST_URI_PART = "home";

    protected static final String MAIN_PAGES_LEVEL_1_DIR = "/pages_level_1/";
    protected static final String MAIN_JSF_DIR = "/pages_level_2/jsf/";
    protected static final String MAIN_PRIMEFACES_DIR = "/pages_level_2/primefaces/";
    protected static final String MAIN_JSF_H_TAGLIB_DIR = "/pages_level_2/jsf/jsf_h_taglib/";
    protected static final String MAIN_JSF_TRICKS_OTHERS_DIR = "/pages_level_2/jsf/_jsf_tricks_others/";
    protected static final String MAIN_STUDENT_HOME_DIR = "/pages_level_1/student_home/";

    public void doFilter(String parentDirPath, Class<?> filterSubClass, ServletRequest request,
                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

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
