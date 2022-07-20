package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._base.AbstractModel;

/**
 * A final class which contains all the basic elements to create a simple HTML page
 *
 * @author Thomas_Mylonas
 * @since 04-Jun-2021
 */
public final class HtmlPageCreationModel extends AbstractModel {

    /**
     * The part of the page which is until the "<title> tag" (page title is excluded)
     * e.g. DisplayConstants.HTML_PAGE_START
     */
    private final String pageStart;

    /**
     * The part of the page which is from the "</title> tag" (page title is excluded),
     * until the "<body> tag" (the "content of the <body> tag" is excluded)
     * e.g. DisplayConstants.HTML_PAGE_MIDDLE
     */
    private final String pageMiddle;

    /**
     * The part of the page which is from the "</body> tag" (the "content of the <body> tag" is excluded),
     * until the end of the page
     * e.g. DisplayConstants.HTML_PAGE_END
     */
    private final String pageEnd;

    /**
     * The page title
     */
    private final String pageTitle;

    /**
     * The "content of the <body> tag"
     */
    private final String pageBody;

    public HtmlPageCreationModel(String pageStart, String pageMiddle, String pageEnd, String pageTitle, String pageBody) {
        this.pageStart = pageStart;
        this.pageMiddle = pageMiddle;
        this.pageEnd = pageEnd;
        this.pageTitle = pageTitle;
        this.pageBody = pageBody;
    }

    @SuppressWarnings("unused")
    public String getPageStart() {
        return pageStart;
    }

    @SuppressWarnings("unused")
    public String getPageMiddle() {
        return pageMiddle;
    }

    @SuppressWarnings("unused")
    public String getPageEnd() {
        return pageEnd;
    }

    @SuppressWarnings("unused")
    public String getPageTitle() {
        return pageTitle;
    }

    @SuppressWarnings("unused")
    public String getPageBody() {
        return pageBody;
    }

    public String createHtmlPage() {
        return pageStart + pageTitle + pageMiddle + pageBody + pageEnd;
    }
}
