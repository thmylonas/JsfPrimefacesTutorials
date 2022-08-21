package com.thomasmylonas.spring_mvc_jsf_pf_web_app.servlet_dispatcher_web_components.servlets;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.servlet_dispatcher_web_components.servlets._base.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Alternative way to declare the servlet - In "web.xml:"
 *
 * <servlet>
 * ----<servlet-name>CounterServlet</servlet-name>
 * ----<servlet-class>path.to.the_servlet.CounterServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * ----<servlet-name>CounterServlet</servlet-name>
 * ----<url-pattern>/counter</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(urlPatterns = "/counter")
public class CounterServlet extends AbstractServlet {

    private int counter;

    @Override
    public void init() throws ServletException {
        counter = 0;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Use the "synchronized"

        response.setContentType("text/html;charset=utf-8");

        PrintWriter responseWriter = response.getWriter();
        counter++;

        htmlCodeStart(responseWriter, "Counter page");

        responseWriter.println("        <h1 style=" + H1_STYLE + ">Counter page</h1>");
        responseWriter.println("        <p>The Counter equals to: \"<span style=" + SPAN_STYLE + ">" + counter + "</span>\"</p>");

        htmlCodeEnd(responseWriter);

        responseWriter.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}
