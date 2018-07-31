package com.malex.constant;

public class Constant
{
    /**
     * Home page
     */
    public final static String INDEX_HTML = "index.html";

    /**
     * Error page
     */
    public final static String ERROR_HTML = "error.html";

    /**
     * The name of  root property file
     */
    public final static String ROOT_PROPERTY_FILE = "application";

    /**
     * Path to config classes
     */
    public final static String CONFIG_LOCATION = "com.malex";

    /**
     * Servlet config
     */
    public final static String MAPPING_URL = "/";
    public final static String SERVLET_NAME = "DispatcherServlet";

    /**
     * Security config
     */
    public final static String FILTER_NAME = "springSecurityFilterChain";
    public final static String TARGET_BEAN_NAME = "springSecurityFilterChain";
    public final static String URL_PATTERNS = "/*";

    /**
     * Multipart config
     */
    public final static String LOCATION = "";
    public final static long MAX_FILE_SIZE = 2000000;
    public final static long MAX_REQUEST_SIZE = 10000000;
    public final static int FILE_SIZE_THRESHOLD = 0;

    /**
     * Default encoding page
     */
    public static final String UTF8 = "UTF-8";

    /**
     * Path to template pages
     */
    public static final String TEMPLATE_PAGES = "/WEB-INF/templates/";

    /**
     * Swagger config
     */
    public final static String SWAGGER_TITLE = "Server REST API";
    public final static String SWAGGER_VERSION = "1.0";
    public final static String SWAGGER_DESCRIPTION = "Application for working with Postgres database";

    /**
     * Error handler
     */
    public final static String SUCCESS_MESSAGE = "Success";
    public final static String ERROR_MESSAGE = "Error";

    /**
     * Link builder
     */
    public final static String LINK_ACTUAL = "actual";
}