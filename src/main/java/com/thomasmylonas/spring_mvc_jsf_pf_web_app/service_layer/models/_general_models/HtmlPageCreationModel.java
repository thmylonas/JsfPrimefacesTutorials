package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models;

/**
 * A record which contains all the basic elements to create a simple HTML page
 *
 * @author Thomas_Mylonas
 * @since 04-Jun-2021
 */
@Deprecated
public record HtmlPageCreationModel(

        /*
        The part of the page which is until the "<title> tag" (page title is excluded), e.g. DisplayConstants.HTML_PAGE_START
        */
        String pageStart,

        /*
        The part of the page which is from the "</title> tag" (page title is excluded),
        until the "<body> tag" (the "content of the <body> tag" is excluded), e.g. DisplayConstants.HTML_PAGE_MIDDLE
        */
        String pageMiddle,

        /*
        The part of the page which is from the "</body> tag" (the "content of the <body> tag" is excluded),
        until the end of the page, e.g. DisplayConstants.HTML_PAGE_END
        */
        String pageEnd,

        /*
        The page title
        */
        String pageTitle,

        /*
        The "content of the <body> tag"
        */
        String pageBody
) {
    public String createHtmlPage() {
        return pageStart + pageTitle + pageMiddle + pageBody + pageEnd;
    }
}
