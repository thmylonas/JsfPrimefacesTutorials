package com.thomasmylonas.spring_mvc_jsf_pf_web_app.servlet_dispatcher_web_components.servlets._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractServlet extends HttpServlet {

    protected final Logger LOGGER = LogManager.getLogger(getClass().getName());

    protected String webappLink;
    protected final String H1_STYLE = "\"color:#FF0099\"";
    protected final String LABEL_STYLE = "\"margin-right:10px;color:#0000FF;font-weight:bold;font-size:18px\"";
    protected final String INPUT_STYLE = "\"padding:5px\"";
    protected final String SUBMIT_STYLE = "\"font-weight:bold;margin-top:10px;padding:10px;border-radius:4px;border:none;color:white;background-color:#0000FF\"";
    protected final String SPAN_STYLE = "\"margin-right:10px;color:#0000FF;font-weight:bold;font-size:18px\"";

    private final String PROPERTIES_FILE_1_DIR = "resource_bundles/messages.properties";

    @Override
    public void init() throws ServletException {

        try {
            webappLink = HelperClass.getPropertyValueFromProperties(PROPERTIES_FILE_1_DIR, "webapp_link");
        } catch (IOException e) {
            LOGGER.error("@@@ In '" + getClass().getSimpleName() + "': The 'webapp_link' is not found!" +
                    " (because 'HelperClass::getPropertyValueFromProperties' throws 'IOException') @@@");
        }
    }

    @Override
    public void destroy() {
    }

    protected void htmlCodeStart(PrintWriter responseWriter, String headTitle) {

        responseWriter.println("<!DOCTYPE html>");
        responseWriter.println("<html lang=\"en\">");

        responseWriter.println("    <head>");
        responseWriter.println("        <title>" + headTitle + "</title>");
        responseWriter.println("    </head>");

        responseWriter.println("    <body>");
    }

    protected void htmlCodeEnd(PrintWriter responseWriter) {
        responseWriter.println("    </body>");
        responseWriter.println("</html>");
    }
}
