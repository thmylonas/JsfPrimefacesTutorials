package com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers;

/**
 * [1]. To display the Objects of a List/Array in a String, separated with a "delimiter", with a "prefix", and a "suffix"
 * (e.g., [object1, object2, ..., object_n], where: prefix: "[", suffix: "]", delimiter: ", "),
 * or
 * [2]. Simply to display Objects in a String,
 * or
 * [3]. In general to display in a String,
 * <p>
 * we need a Collection of Constants to help in this display, which is provided by this class
 *
 * @author Thomas_Mylonas
 * @since 04-Jun-2021
 */
public abstract class DisplayConstants {

    /**
     * A String[] with the pattern: [delimiter, prefix, suffix], where:
     * delimiter: ", ",
     * prefix: "[",
     * suffix: "]"
     * This array is for simple uses like: [object1, object2, ..., object_n]
     */
    public static final String[] DISPLAY_INLINE_IN_CONSOLE = {", ", "[", "]"};

    /**
     * A String[] with the pattern: [delimiter, prefix, suffix], where:
     * delimiter: ", " + System.lineSeparator(),
     * prefix: "[",
     * suffix: "]"
     * This array is for simple uses like:
     * [object1,
     * object2,
     * ...,
     * object_n]
     */
    public static final String[] DISPLAY_OBJECTS_IN_CONSOLE = {", " + System.lineSeparator(), "[", "]"};

    /**
     * A String[] with the pattern: [delimiter, prefix, suffix] = [", <br/>", "<br/>[<br/>", "<br/>]<br/>"], where:
     * delimiter: ", <br/>",
     * prefix: "<br/>[<br/>",
     * suffix: "<br/>]<br/>"
     * This array can be used in EL in the tags of JSF pages
     */
    public static final String[] DISPLAY_OBJECTS_IN_GUI1 = {", <br/>", "<br/>[<br/>", "<br/>]<br/>"};

    /**
     * A String[] with the pattern: [delimiter, prefix, suffix] = [", <br/>", "<br/>[<br/>", "<br/>]<br/>"], where:
     * delimiter: ", <br/>",
     * prefix: "<br/>[<br/>",
     * suffix: "<br/>]<br/>"
     * This array can be used in EL in the tags of JSF pages
     */
    public static final String[] DISPLAY_OBJECTS_IN_GUI2 = {", &lt;br/&gt;", "&lt;br/&gt;[&lt;br/&gt;", "&lt;br/&gt;]&lt;br/&gt;"};

    /**
     * The new line symbol ("\n" in Linux/Unix systems, and "\r\n" in Windows systems), to be used in Console
     */
    public static final String NEWLINE_IN_CONSOLE = System.lineSeparator();

    /**
     * The new line symbol "<br/>", to be used in EL in the tags of JSF pages
     */
    public static final String NEWLINE_IN_GUI1 = "<br/>";

    /**
     * The new line symbol "<br/>", to be used in EL in the tags of JSF pages
     */
    public static final String NEWLINE_IN_GUI2 = "&lt;br/&gt;";

    /**
     * The start of a Test HTML page, for demonstration reasons (<title>Title</title> included)
     */
    public static final String TEST_HTML_PAGE_START = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"/><title>Test Page</title></head><body>";

    /**
     * The start of an HTML page, for demonstration reasons
     */
    public static final String HTML_PAGE_START = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"/><title>";

    /**
     * The middle of an HTML page, for demonstration reasons
     */
    public static final String HTML_PAGE_MIDDLE = "</title></head><body>";

    /**
     * The end of an HTML page, for demonstration reasons
     */
    public static final String HTML_PAGE_END = "</body></html>";
}
