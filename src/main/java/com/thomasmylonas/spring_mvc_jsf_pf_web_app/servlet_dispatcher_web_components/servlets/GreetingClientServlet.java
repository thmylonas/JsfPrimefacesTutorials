package com.thomasmylonas.spring_mvc_jsf_pf_web_app.servlet_dispatcher_web_components.servlets;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.servlet_dispatcher_web_components.servlets._base.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Alternative way to declare the servlet - In "web.xml:"
 *
 * <servlet>
 * ----<servlet-name>GreetingClientServlet</servlet-name>
 * ----<servlet-class>path.to.the_servlet.GreetingClientServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * ----<servlet-name>GreetingClientServlet</servlet-name>
 * ----<url-pattern>/greeting-client</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(urlPatterns = "/greeting-client")
public class GreetingClientServlet extends AbstractServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=utf-8");

        PrintWriter responseWriter = response.getWriter();

        htmlCodeStart(responseWriter, "Server sends greetings to the client");

        responseWriter.println("        <h1 style=" + H1_STYLE + ">Server sends greetings to the client</h1>");

        responseWriter.println("        <form method=\"POST\" action=\"" + webappLink + "greeting-client\">");
        responseWriter.println("            <fieldset>");
        responseWriter.println("                <legend>Send Name</legend>");
        responseWriter.println("                <label for=\"greetingId\" style=" + LABEL_STYLE + ">Client insert your name:</label>");
        responseWriter.println("                <input id=\"greetingId\" type=\"text\" style=" + INPUT_STYLE + "name=\"send-greetings\" placeholder=\"Insert name\"/>");
        responseWriter.println("        <br/>");
        responseWriter.println("                <input type=\"submit\" style=" + SUBMIT_STYLE + " value=\"Submit Name\"/>");
        responseWriter.println("            </fieldset>");
        responseWriter.println("        </form>");

        htmlCodeEnd(responseWriter);

        responseWriter.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=utf-8");

        PrintWriter responseWriter = response.getWriter();

        /*
        // Use "sendRedirect" somehow (?)
        response.sendRedirect(URL);
        */

        Enumeration<String> params = request.getParameterNames();
        ArrayList<String> paramsList = new ArrayList<>();

        while (params.hasMoreElements()) {
            String e = params.nextElement();
            paramsList.add(request.getParameter(e));
        }

        String name = paramsList.get(0);

        htmlCodeStart(responseWriter, "Server sends greetings to the client");

        responseWriter.println("        <h1 style=" + H1_STYLE + ">Server sends greetings to the client</h1>");
        responseWriter.println("        <p>Server says: \"<span style=" + SPAN_STYLE + ">" + name + "</span>\"</p>");

        htmlCodeEnd(responseWriter);

        responseWriter.close();
    }
}
