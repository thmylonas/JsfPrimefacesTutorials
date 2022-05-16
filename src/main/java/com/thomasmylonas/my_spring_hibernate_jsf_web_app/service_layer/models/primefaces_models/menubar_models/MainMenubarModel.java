package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.primefaces_models.menubar_models;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.primefaces_models.menubar_models._base.AbstractMenubarModel;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

//@Component(value = "mainMenubarModel")
public class MainMenubarModel extends AbstractMenubarModel {

    private final MenuModel menuModel = new DefaultMenuModel();

    //@PostConstruct
    @SuppressWarnings("unused")
    private void init() {

        /////////////////////////////////////////////////////////////////////////
        // Item Level 1 - Home
        /////////////////////////////////////////////////////////////////////////

        DefaultMenuItem item = DefaultMenuItem.builder().value("Home").url(WEBAPP_LINK + "home").build();
        menuModel.getElements().add(item);

        /////////////////////////////////////////////////////////////////////////
        // SubMenu Level 1 - Programming
        /////////////////////////////////////////////////////////////////////////

        DefaultSubMenu programmingSubmenu = buildDefaultSubMenu("Programming");

        item = buildDefaultMenuItem("Java SE Programming", "java", WEBAPP_LINK + "facelets/java");
        programmingSubmenu.getElements().add(item);

        // SubMenu Level 2 - Java EE Programming

        DefaultSubMenu javaEeSubmenu = buildDefaultSubMenu("Java EE Programming", "java_ee");

        // SubMenu Level 3 - Java EE / Web Programming

        DefaultSubMenu javaEeWebSubmenu = buildDefaultSubMenu("Java EE / Web Programming", "java_ee");

        item = buildDefaultMenuItem("Servlets Framework", "servlets_framework", WEBAPP_LINK + "servlets-framework");
        javaEeWebSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Spring Framework", "spring_framework", WEBAPP_LINK + "spring-framework");
        javaEeWebSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Thymeleaf Framework", "thymeleaf", WEBAPP_LINK + "thymeleaf");
        javaEeWebSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("JavaServer Pages (with JSTL)", "jsp_jstl", WEBAPP_LINK + "jsp-jstl");
        javaEeWebSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Enterprise JavaBeans", "ejb", WEBAPP_LINK + "ejb");
        javaEeWebSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Jax-RS Framework", "jax_rs_framework", WEBAPP_LINK + "jax-rs-framework");
        javaEeWebSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("JavaServer Faces", "jsf", WEBAPP_LINK + "facelets/jsf");
        javaEeWebSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Primefaces", "primefaces", WEBAPP_LINK + "facelets/primefaces");
        javaEeWebSubmenu.getElements().add(item);

        javaEeSubmenu.getElements().add(javaEeWebSubmenu);

        item = buildDefaultMenuItem("ORM: Hibernate/JPA", "hibernate", WEBAPP_LINK + "hibernate-jpa-orm");
        javaEeSubmenu.getElements().add(item);

        programmingSubmenu.getElements().add(javaEeSubmenu);

        // SubMenu Level 2 - Web Developing

        DefaultSubMenu webDevelopingSubmenu = buildDefaultSubMenu("Web Developing", "http");

        // SubMenu Level 3 - World Wide Web Theory

        DefaultSubMenu webTheorySubmenu = buildDefaultSubMenu("World Wide Web Theory", "http");

        item = buildDefaultMenuItem("World Wide Web Theory", "www", WEBAPP_LINK + "www");
        webTheorySubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Web Services & REST", "restful_services", WEBAPP_LINK + "rest");
        webTheorySubmenu.getElements().add(item);

        webDevelopingSubmenu.getElements().add(webTheorySubmenu);

        // SubMenu Level 3 - Markup Languages

        DefaultSubMenu markupLangsSubmenu = buildDefaultSubMenu("Markup Languages", "markup_langs");

        item = buildDefaultMenuItem("HTML Language", "html", WEBAPP_LINK + "html");
        markupLangsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("CSS Language", "css", WEBAPP_LINK + "css");
        markupLangsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("XML Language", "xml", WEBAPP_LINK + "xml");
        markupLangsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("JavaScript Object Notation", "json", WEBAPP_LINK + "json");
        markupLangsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("XQuery Language", "xquery", WEBAPP_LINK + "xquery");
        markupLangsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("XPath Language", "xpath", WEBAPP_LINK + "xpath");
        markupLangsSubmenu.getElements().add(item);

        webDevelopingSubmenu.getElements().add(markupLangsSubmenu);

        // SubMenu Level 3 - Scripting Languages

        DefaultSubMenu scriptingLangsSubmenu = buildDefaultSubMenu("Scripting Languages", "scripting_langs");

        item = buildDefaultMenuItem("JavaScript Programming", "javascript", WEBAPP_LINK + "javascript");
        scriptingLangsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("PHP Programming", "php", WEBAPP_LINK + "php");
        scriptingLangsSubmenu.getElements().add(item);

        webDevelopingSubmenu.getElements().add(scriptingLangsSubmenu);

        item = buildDefaultMenuItem("Bootstrap Framework", "bootstrap", WEBAPP_LINK + "bootstrap");
        webDevelopingSubmenu.getElements().add(item);

        item = buildDefaultMenuItem("Content Management Systems", "cms", WEBAPP_LINK + "cms");
        webDevelopingSubmenu.getElements().add(item);

        programmingSubmenu.getElements().add(webDevelopingSubmenu);

        item = buildDefaultMenuItem("Android Programming", "android", WEBAPP_LINK + "android");
        programmingSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("C & C++ Programming", "cpp", WEBAPP_LINK + "c-cpp");
        programmingSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Qt & QtQuick Programming", "qt_quick", WEBAPP_LINK + "qt-quick");
        programmingSubmenu.getElements().add(item);

        menuModel.getElements().add(programmingSubmenu);

        /////////////////////////////////////////////////////////////////////////
        // SubMenu Level 1 - Data Science
        /////////////////////////////////////////////////////////////////////////

        DefaultSubMenu dataScienceSubmenu = buildDefaultSubMenu("Data Science");

        item = buildDefaultMenuItem("Algorithms", "algorithms", WEBAPP_LINK + "algorithms");
        dataScienceSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Data Structures", "data_structures", WEBAPP_LINK + "data-structures");
        dataScienceSubmenu.getElements().add(item);

        // SubMenu Level 2 - Databases

        DefaultSubMenu databasesSubmenu = buildDefaultSubMenu("Databases", "database_sql");

        // SubMenu Level 3 - Theory in Databases

        DefaultSubMenu theoryInDatabasesSubmenu = buildDefaultSubMenu("Theory in Databases", "database_sql");

        item = buildDefaultMenuItem("Databases Basic Theory & SQL", "database_sql", WEBAPP_LINK + "db-basic-theory-sql");
        theoryInDatabasesSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Database Technology", "db_technology", WEBAPP_LINK + "db-technology");
        theoryInDatabasesSubmenu.getElements().add(item);

        databasesSubmenu.getElements().add(theoryInDatabasesSubmenu);

        // SubMenu Level 3 - DBMSs

        DefaultSubMenu dbmsSubmenu = buildDefaultSubMenu("DBMSs", "oracle_db");

        item = buildDefaultMenuItem("Oracle DB", "oracle_db", WEBAPP_LINK + "oracle-db");
        dbmsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("MS SQL Server", "ms_sql_server", WEBAPP_LINK + "ms-sql-server");
        dbmsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("MySQL", "mysql", WEBAPP_LINK + "mysql");
        dbmsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("SQLite", "sqlite", WEBAPP_LINK + "sqlite");
        dbmsSubmenu.getElements().add(item);

        databasesSubmenu.getElements().add(dbmsSubmenu);

        // SubMenu Level 3 - No-SQL DBMSs

        DefaultSubMenu noSqlSubmenu = buildDefaultSubMenu("No-SQL DBMSs", "mongo_db");

        item = buildDefaultMenuItem("Mongo DB", "mongo_db", WEBAPP_LINK + "mongo-db");
        noSqlSubmenu.getElements().add(item);

        databasesSubmenu.getElements().add(noSqlSubmenu);

        dataScienceSubmenu.getElements().add(databasesSubmenu);

        item = buildDefaultMenuItem("Information Retrieval", "info_retrieval", WEBAPP_LINK + "info-retrieval");
        dataScienceSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Data Warehouses & Data Mining", "data_warehouses_data_mining", WEBAPP_LINK + "data-warehouses-data-mining");
        dataScienceSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Computational Geometry", "computational_geometry", WEBAPP_LINK + "computational-geometry");
        dataScienceSubmenu.getElements().add(item);

        // SubMenu Level 2 - Mathematics

        DefaultSubMenu mathsSubmenu = buildDefaultSubMenu("Mathematics for Computers", "maths");

        item = buildDefaultMenuItem("Statistics", "statistics", WEBAPP_LINK + "statistics");
        mathsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Probability Theory", "probability_theory", WEBAPP_LINK + "probability-theory");
        mathsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Numerical Analysis", "numerical_analysis", WEBAPP_LINK + "numerical-analysis");
        mathsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Discrete Mathematics", "discrete_maths", WEBAPP_LINK + "discrete-maths");
        mathsSubmenu.getElements().add(item);

        dataScienceSubmenu.getElements().add(mathsSubmenu);

        menuModel.getElements().add(dataScienceSubmenu);

        /////////////////////////////////////////////////////////////////////////
        // SubMenu Level 1 - Artificial Intelligence
        /////////////////////////////////////////////////////////////////////////

        DefaultSubMenu aiSubmenu = buildDefaultSubMenu("Artificial Intelligence");

        item = buildDefaultMenuItem("Introduction to A.I.", "ai", WEBAPP_LINK + "intro-to-ai");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Planning", "planning", WEBAPP_LINK + "planning");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Intelligent & Autonomous Systems", "intelligent_autonomous_systems", WEBAPP_LINK + "intelligent-autonomous-systems");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Machine Learning", "machine_learning", WEBAPP_LINK + "machine-learning");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Multi-agent Systems", "multi_agent_systems", WEBAPP_LINK + "multi-agent-systems");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Game Theory", "game_theory", WEBAPP_LINK + "game-theory");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Artificial Neuronic Networks", "artificial_neuronic_networks", WEBAPP_LINK + "artificial-neuronic-networks");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Genetic Algorithms", "genetic_algorithms", WEBAPP_LINK + "genetic-algorithms");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Fuzzy Logic", "fuzzy_logic", WEBAPP_LINK + "fuzzy-logic");
        aiSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Constraint Satisfaction Problems", "constraint_satisfaction_problems", WEBAPP_LINK + "constraint-satisfaction-problems");
        aiSubmenu.getElements().add(item);

        menuModel.getElements().add(aiSubmenu);

        /////////////////////////////////////////////////////////////////////////
        // SubMenu Level 1 - IT Systems
        /////////////////////////////////////////////////////////////////////////

        DefaultSubMenu itSystemsSubmenu = buildDefaultSubMenu("IT Systems");

        // SubMenu Level 2 - Operating Systems

        DefaultSubMenu operatingSystemsSubmenu = buildDefaultSubMenu("Operating Systems", "os");

        item = buildDefaultMenuItem("O.S. Basic Theory", "os", WEBAPP_LINK + "os-basic-theory");
        operatingSystemsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Windows", "windows", WEBAPP_LINK + "windows");
        operatingSystemsSubmenu.getElements().add(item);

        // SubMenu Level 3 - Linux

        DefaultSubMenu linuxSubmenu = buildDefaultSubMenu("Linux", "linux");

        item = buildDefaultMenuItem("Ubuntu", "ubuntu", WEBAPP_LINK + "ubuntu");
        linuxSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Linux Mint", "linux_mint", WEBAPP_LINK + "linux-mint");
        linuxSubmenu.getElements().add(item);

        operatingSystemsSubmenu.getElements().add(linuxSubmenu);

        itSystemsSubmenu.getElements().add(operatingSystemsSubmenu);

        item = buildDefaultMenuItem("Distributed Systems", "distributed_systems", WEBAPP_LINK + "distributed-systems");
        itSystemsSubmenu.getElements().add(item);

        // SubMenu Level 2 - Application Servers

        DefaultSubMenu applicationServersSubmenu = buildDefaultSubMenu("Application Servers", "servers");

        item = buildDefaultMenuItem("Application Servers Basic Theory", "servers", WEBAPP_LINK + "servers");
        applicationServersSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Apache HTTP Server", "apache", WEBAPP_LINK + "apache");
        applicationServersSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Apache Tomcat", "tomcat", WEBAPP_LINK + "tomcat");
        applicationServersSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Eclipse GlassFish", "glassfish", WEBAPP_LINK + "glassfish");
        applicationServersSubmenu.getElements().add(item);

        itSystemsSubmenu.getElements().add(applicationServersSubmenu);

        // SubMenu Level 2 - Version Control Systems (VCSs)

        DefaultSubMenu versionControlSystemsSubmenu = buildDefaultSubMenu("Version Control Systems (VCSs)", "git");

        item = buildDefaultMenuItem("Git", "git", WEBAPP_LINK + "git");
        versionControlSystemsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Bitbucket", "bitbucket", WEBAPP_LINK + "bitbucket");
        versionControlSystemsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("GitHub", "github", WEBAPP_LINK + "github");
        versionControlSystemsSubmenu.getElements().add(item);

        itSystemsSubmenu.getElements().add(versionControlSystemsSubmenu);

        // SubMenu Level 2 - Build Automation Tools

        DefaultSubMenu buildAutomationToolsSubmenu = buildDefaultSubMenu("Build Automation Tools", "maven");

        item = buildDefaultMenuItem("Apache Maven", "maven", WEBAPP_LINK + "maven");
        buildAutomationToolsSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Apache Gradle", "gradle", WEBAPP_LINK + "gradle");
        buildAutomationToolsSubmenu.getElements().add(item);

        itSystemsSubmenu.getElements().add(buildAutomationToolsSubmenu);

        menuModel.getElements().add(itSystemsSubmenu);

        /////////////////////////////////////////////////////////////////////////
        // SubMenu Level 1 - Architecture & Hardware
        /////////////////////////////////////////////////////////////////////////

        DefaultSubMenu hardwareSubmenu = buildDefaultSubMenu("Architecture & Hardware");

        item = buildDefaultMenuItem("Digital Design", "digital_design", WEBAPP_LINK + "digital-design");
        hardwareSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Electronics", "electronics", WEBAPP_LINK + "electronics");
        hardwareSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Computer Organization & Architecture", "architecture", WEBAPP_LINK + "architecture");
        hardwareSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Computer Networks", "networks", WEBAPP_LINK + "networks");
        hardwareSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Systems & Signals", "systems_signals", WEBAPP_LINK + "systems-signals");
        hardwareSubmenu.getElements().add(item);

        menuModel.getElements().add(hardwareSubmenu);

        /////////////////////////////////////////////////////////////////////////
        // SubMenu Level 1 - About Me
        /////////////////////////////////////////////////////////////////////////

        DefaultSubMenu aboutMeSubmenu = buildDefaultSubMenu("About Me");

        item = buildDefaultMenuItem("My Resume", "my_cv", WEBAPP_LINK + "my-cv");
        aboutMeSubmenu.getElements().add(item);
        item = buildDefaultMenuItem("Contact Information", "contact_info", WEBAPP_LINK + "contact-info");
        aboutMeSubmenu.getElements().add(item);

        menuModel.getElements().add(aboutMeSubmenu);
    }

    @SuppressWarnings("unused")
    public MenuModel getMenuModel() {
        return menuModel;
    }
}
