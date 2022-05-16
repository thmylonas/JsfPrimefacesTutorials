package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer._enums;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;

import java.util.Arrays;

public enum ImagesEnum {

    // "images/java_frameworks"
    EJB_IMAGE("EnterpriseJavaBeans", ".png", "Enterprise JavaBeans (EJBs)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    HIBERNATE_IMAGE("Hibernate", ".png", "Hibernate", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    JAVA_EE_IMAGE("JavaEe", ".png", "Java EE", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    JAVA_IMAGE("Java", ".png", "Java", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    JAVA_SERVER_FACES_IMAGE("JavaServerFaces", ".jpg", "JavaServer Faces", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    JAVA_SERVER_PAGES_IMAGE("JavaServerPages", ".jpg", "JavaServer Pages", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    JAX_RS_FRAMEWORK_IMAGE("JaxRsFramework", ".jpg", "Jax-RS Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    PRIMEFACES_IMAGE("Primefaces", ".png", "Primefaces", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    SERVLETS_FRAMEWORK_IMAGE("ServletsFramework", ".png", "Servlets Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    SPRING_FRAMEWORK_IMAGE("SpringFramework", ".png", "Spring Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    THYMELEAF_IMAGE("Thymeleaf", ".png", "Thymeleaf Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),

    // "images/cs_topics"
    AI_IMAGE("Ai", ".jpg", "Introduction to Artificial Intelligence (A.I.)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    ALGORITHMS_IMAGE("Algorithms", ".gif", "Algorithms", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    ANDROID_IMAGE("Android", ".jpg", "Android Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    APACHE_IMAGE("Apache", ".png", "Apache HTTP Server", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    ARCHITECTURE_IMAGE("Architecture", ".jpg", "Computer Organization & Architecture", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    ARTIFICIAL_NEURONIC_NETWORKS_IMAGE("ArtificialNeuronicNetworks", ".png", "Artificial Neuronic Networks", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    BITBUCKET_IMAGE("Bitbucket", ".jpg", "Bitbucket", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    BOOTSTRAP_IMAGE("Bootstrap", ".jpg", "Bootstrap Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    CMS_IMAGE("Cms", ".png", "Content Management Systems (CMS)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    COMPUTATIONAL_GEOMETRY_IMAGE("ComputationalGeometry", ".jpg", "Computational Geometry", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    CONSTRAINT_SATISFACTION_PROBLEMS_IMAGE("ConstraintSatisfactionProblems", ".png", "Constraint Satisfaction Problems (CSP)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    CPP_IMAGE("Cpp", ".jpg", "C & C++ Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    CSS_IMAGE("Css", ".jpg", "CSS Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    DATABASE_SQL_IMAGE("DatabaseSql", ".jpg", "Databases - Basic Theory & SQL", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    DATA_STRUCTURES_IMAGE("DataStructures", ".jpg", "Data Structures", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    DATA_WAREHOUSES_DATA_MINING_IMAGE("DataWarehousesDataMining", ".jpg", "Data Warehouses & Data Mining", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    DB_TECHNOLOGY_IMAGE("DbTechnology", ".jpg", "Database Technology", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    DIGITAL_DESIGN_IMAGE("DigitalDesign", ".jpg", "Digital Design", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    DISCRETE_MATHS_IMAGE("DiscreteMaths", ".jpg", "Discrete Mathematics", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    DISTRIBUTED_SYSTEMS_IMAGE("DistributedSystems", ".jpg", "Distributed Systems", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    ELECTRONICS_IMAGE("Electronics", ".jpg", "Electronics", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    FUZZY_LOGIC_IMAGE("FuzzyLogic", ".jpg", "Fuzzy Logic", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    GAME_THEORY_IMAGE("GameTheory", ".jpg", "Game Theory", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    GENETIC_ALGORITHMS_IMAGE("GeneticAlgorithms", ".png", "Genetic Algorithms", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    GIT_IMAGE("Git", ".png", "Git", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    GIT1_IMAGE("Git1", ".jpg", "Git_1", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    GIT2_IMAGE("Git2", ".jpg", "Git_2", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    GITHUB_IMAGE("GitHub", ".png", "GitHub", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    GLASSFISH_IMAGE("GlassFish", ".jpg", "GlassFish", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    GRADLE_IMAGE("Gradle", ".png", "Apache Gradle", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    HTML_IMAGE("Html", ".png", "HTML Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    INFO_RETRIEVAL_IMAGE("InfoRetrieval", ".jpg", "Information Retrieval", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    INTELLIGENT_AUTONOMOUS_SYSTEMS_IMAGE("IntelligentAutonomousSystems", ".jpg", "Intelligent & Autonomous Systems", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    JAVASCRIPT_IMAGE("Javascript", ".png", "JavaScript Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    JSON_IMAGE("Json", ".png", "JavaScript Object Notation (JSON)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    LINUX_MINT_IMAGE("LinuxMint", ".jpg", "Linux Mint", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MACHINE_LEARNING_IMAGE("MachineLearning", ".jpg", "Machine Learning", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MAVEN_IMAGE("Maven", ".png", "Apache Maven", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MONGO_DB_IMAGE("MongoDb", ".png", "Mongo Database", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MS_SQL_SERVER_IMAGE("MsSqlServer", ".png", "The DBMS: Microsoft SQL Server", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MULTI_AGENT_SYSTEMS_IMAGE("MultiAgentSystems", ".jpg", "Multi-agent Systems", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MYSQL_IMAGE("Mysql", ".png", "The DBMS: MySQL", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    NETWORKS_IMAGE("Networks", ".jpg", "Computer Networks", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    NUMERICAL_ANALYSIS_IMAGE("NumericalAnalysis", ".jpg", "Numerical Analysis", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    ORACLE_DB_IMAGE("OracleDb", ".jpg", "The DBMS: Oracle Database", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    OS_IMAGE("Os", ".jpg", "Operating Systems - Basic Theory", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    PHP_IMAGE("Php", ".png", "PHP Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    PLANNING_IMAGE("Planning", ".gif", "Planning", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    PROBABILITY_THEORY_IMAGE("ProbabilityTheory", ".png", "Probability Theory", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    QT_IMAGE("Qt", ".png", "Qt & QtQuick Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    RESTFUL_SERVICES_IMAGE("RestfulServices", ".png", "Web Services & REST", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    SERVERS_IMAGE("Servers", ".png", "Application Servers - Basic Theory", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    SERVERS1_IMAGE("Servers1", ".png", "Servers_1", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    SQLITE_IMAGE("Sqlite", ".png", "The DBMS: SQLite", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    STATISTICS_IMAGE("Statistics", ".png", "Statistics", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    SYSTEMS_SIGNALS_IMAGE("SystemsSignals", ".jpg", "Systems & Signals", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    TOMCAT_IMAGE("Tomcat", ".jpg", "Apache Tomcat", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    UBUNTU_IMAGE("Ubuntu", ".png", "Ubuntu", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    WINDOWS_IMAGE("Windows", ".jpg", "Windows", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    WWW_IMAGE("Www", ".jpg", "World Wide Web (WWW)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    XML_IMAGE("Xml", ".jpg", "XML Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    XPATH_IMAGE("Xpath", ".jpg", "XPath Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    XQUERY_IMAGE("Xquery", ".jpg", "XQuery Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),

    // "images/social_media"
    FACEBOOK_IMAGE("Facebook", ".png", "Facebook", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_SOCIAL_MEDIA_DIR),
    GOOGLE_PLUS_IMAGE("GooglePlus", ".png", "GooglePlus", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_SOCIAL_MEDIA_DIR),
    INSTAGRAM_IMAGE("Instagram", ".png", "Instagram", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_SOCIAL_MEDIA_DIR),
    LINKEDIN_IMAGE("LinkedIn", ".png", "LinkedIn", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_SOCIAL_MEDIA_DIR),

    // "images/navigation_btns"
    BACK_TO_HOME_IMAGE("BackToHome", ".png", "Back Home", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_NAVIGATION_BTNS_DIR),
    BACK_TO_TOP_IMAGE("BackToTop", ".png", "Back to Top", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_NAVIGATION_BTNS_DIR),

    // "images/about"
    CONTACT_INFO_IMAGE("ContactInfo", ".jpg", "Contact Info", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_ABOUT_DIR),
    MY_CV_IMAGE("MyCv", ".png", "My Cv", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_ABOUT_DIR),
    THOMAS_MYLONAS_IMAGE("ThomasMylonas", ".jpg", "Thomas Mylonas", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_ABOUT_DIR),

    // "images/backgrounds"
    JAVA_CODING_BG_IMAGE("JavaCodingBg", ".jpg", "JavaCodingBg", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_BACKGROUNDS_DIR),
    PINK_BG_IMAGE("PinkBg", ".jpg", "PinkBg", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_BACKGROUNDS_DIR),
    RED_BG_IMAGE("RedBg", ".jpg", "RedBg", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_BACKGROUNDS_DIR),

    // "images/langs"
    EN_IMAGE("En", ".png", "English Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_LANGS_DIR),
    GR_IMAGE("Gr", ".jpg", "Greek Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_LANGS_DIR),

    // "images/menubar_icons/java_frameworks"
    MENUBAR_ICON_EJB_IMAGE("EnterpriseJavaBeans", ".png", "Enterprise JavaBeans (EJBs)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_HIBERNATE_IMAGE("Hibernate", ".png", "Hibernate", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_JAVA_EE_IMAGE("JavaEe", ".png", "Java EE", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_JAVA_IMAGE("Java", ".png", "Java", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_JAVA_SERVER_FACES_IMAGE("JavaServerFaces", ".png", "JavaServer Faces", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_JAVA_SERVER_PAGES_IMAGE("JavaServerPages", ".jpg", "JavaServer Pages", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_JAX_RS_FRAMEWORK_IMAGE("JaxRsFramework", ".png", "Jax-RS Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_PRIMEFACES_IMAGE("Primefaces", ".png", "Primefaces", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_SERVLETS_FRAMEWORK_IMAGE("ServletsFramework", ".png", "Servlets Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_SPRING_FRAMEWORK_IMAGE("SpringFramework", ".png", "Spring Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),
    MENUBAR_ICON_THYMELEAF_IMAGE("Thymeleaf", ".png", "Thymeleaf Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_JAVA_FRAMEWORKS_DIR),

    // "images/menubar_icons/cs_topics"
    MENUBAR_ICON_AI_IMAGE("Ai", ".jpg", "Introduction to Artificial Intelligence (A.I.)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_ANDROID_IMAGE("Android", ".png", "Android Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_APACHE_IMAGE("Apache", ".png", "Apache HTTP Server", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_ARCHITECTURE_IMAGE("Architecture", ".png", "Computer Organization & Architecture", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_ARTIFICIAL_NEURONIC_NETWORKS_IMAGE("ArtificialNeuronicNetworks", ".png", "Artificial Neuronic Networks", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_BITBUCKET_IMAGE("Bitbucket", ".png", "Bitbucket", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_BOOTSTRAP_IMAGE("Bootstrap", ".png", "Bootstrap Framework", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_CHESS_IMAGE("Chess", ".png", "Chess", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_CMS_IMAGE("Cms", ".png", "Content Management Systems (CMS)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_COMPUTATIONAL_GEOMETRY_IMAGE("ComputationalGeometry", ".png", "Computational Geometry", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_CPP_IMAGE("Cpp", ".jpg", "C & C++ Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_CSS_IMAGE("Css", ".jpg", "CSS Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_DATABASE_SQL_IMAGE("DatabaseSql", ".png", "Databases - Basic Theory & SQL", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_DATA_CUBE_IMAGE("DataCube", ".png", "Data Cube", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_DATA_STRUCTURES_IMAGE("DataStructures", ".png", "Data Structures", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_DB_TECHNOLOGY_IMAGE("DbTechnology", ".png", "Database Technology", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_DIGITAL_DESIGN_IMAGE("DigitalDesign", ".png", "Digital Design", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_DISCRETE_MATHS_IMAGE("DiscreteMaths", ".png", "Discrete Mathematics", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_DISTRIBUTED_SYSTEMS_IMAGE("DistributedSystems", ".png", "Distributed Systems", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_ELECTRONICS_IMAGE("Electronics", ".png", "Electronics", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_FUZZY_LOGIC_IMAGE("FuzzyLogic", ".jpg", "Fuzzy Logic", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_GENETIC_ALGORITHMS_IMAGE("GeneticAlgorithms", ".png", "Genetic Algorithms", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_GIT_IMAGE("Git", ".png", "Git", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_GITHUB_IMAGE("GitHub", ".png", "GitHub", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_GLASSFISH_IMAGE("GlassFish", ".png", "GlassFish", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_GRADLE_IMAGE("Gradle", ".png", "Apache Gradle", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_HTML_IMAGE("Html", ".jpg", "HTML Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_HTTP_IMAGE("Http", ".png", "HTTP", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_INFO_RETRIEVAL_IMAGE("InfoRetrieval", ".png", "Information Retrieval", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_INTELLIGENT_AUTONOMOUS_SYSTEMS_IMAGE("IntelligentAutonomousSystems", ".jpg", "Intelligent & Autonomous Systems", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_JAVASCRIPT_IMAGE("Javascript", ".png", "JavaScript Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_JSON_IMAGE("Json", ".png", "JavaScript Object Notation (JSON)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_LINUX_IMAGE("Linux", ".png", "Linux", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_LINUX_MINT_IMAGE("LinuxMint", ".png", "Linux Mint", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_MACHINE_LEARNING_IMAGE("MachineLearning", ".jpg", "Machine Learning", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_MARKUP_LANGS_IMAGE("MarkupLangs", ".png", "Markup Languages", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_MATHS_IMAGE("Maths", ".png", "Mathematics", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_MAVEN_IMAGE("Maven", ".png", "Apache Maven", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_MONGO_DB_IMAGE("MongoDb", ".png", "Mongo Database", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_MS_SQL_SERVER_IMAGE("MsSqlServer", ".png", "The DBMS: Microsoft SQL Server", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_MULTI_AGENT_SYSTEMS_IMAGE("MultiAgentSystems", ".jpg", "Multi-agent Systems", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_MYSQL_IMAGE("Mysql", ".png", "The DBMS: MySQL", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_NETWORKS_IMAGE("Networks", ".png", "Computer Networks", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_NUMERICAL_ANALYSIS_IMAGE("NumericalAnalysis", ".png", "Numerical Analysis", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_ORACLE_DB_IMAGE("OracleDb", ".jpg", "The DBMS: Oracle Database", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_OS_IMAGE("Os", ".png", "Operating Systems - Basic Theory", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_PHP_IMAGE("Php", ".png", "PHP Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_PLANNING_IMAGE("Planning", ".png", "Planning", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_PROBABILITY_THEORY_IMAGE("ProbabilityTheory", ".png", "Probability Theory", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_QT_IMAGE("Qt", ".png", "Qt & QtQuick Programming", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_RESTFUL_SERVICES_IMAGE("RestfulServices", ".png", "Web Services & REST", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_RUBIK_IMAGE("Rubik", ".png", "Rubik", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_SCRIPTING_LANGS_IMAGE("ScriptingLangs", ".png", "Scripting Languages", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_SERVERS_IMAGE("Servers", ".png", "Application Servers - Basic Theory", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_SQLITE_IMAGE("Sqlite", ".png", "The DBMS: SQLite", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_STATISTICS_IMAGE("Statistics", ".png", "Statistics", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_SUDOKU_IMAGE("Sudoku", ".png", "Sudoku", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_SYSTEMS_SIGNALS_IMAGE("SystemsSignals", ".png", "Systems & Signals", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_TOMCAT_IMAGE("Tomcat", ".png", "Apache Tomcat", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_UBUNTU_IMAGE("Ubuntu", ".png", "Ubuntu", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_WINDOWS_IMAGE("Windows", ".jpg", "Windows", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_WWW_IMAGE("Www", ".png", "World Wide Web (WWW)", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_XML_IMAGE("Xml", ".jpg", "XML Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_XPATH_IMAGE("Xpath", ".png", "XPath Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),
    MENUBAR_ICON_XQUERY_IMAGE("Xquery", ".png", "XQuery Language", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_CS_TOPICS_DIR),

    // "images/menubar_icons/about"
    MENUBAR_ICON_CONTACT_INFO_IMAGE("ContactInfo", ".png", "Contact Info", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_ABOUT_DIR),
    MENUBAR_ICON_THOMAS_MYLONAS_IMAGE("ThomasMylonas", ".jpg", "Thomas Mylonas", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR + ImagesEnum.MAIN_IMAGES_ABOUT_DIR),

    // "images/menubar_icons"
    MENUBAR_ICON_HOME_IMAGE("Home", ".png", "Home", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR),
    MENUBAR_ICON_LOGOUT_IMAGE("Logout", ".png", "Logout", ImagesEnum.MAIN_IMAGES_DIR + ImagesEnum.MAIN_IMAGES_MENUBAR_ICON_DIR),

    // Empty Value
    EMPTY_VALUE("", "", "", "");

    static final String MAIN_IMAGES_DIR = "images/";
    static final String MAIN_IMAGES_ABOUT_DIR = "about/";
    static final String MAIN_IMAGES_BACKGROUNDS_DIR = "backgrounds/";
    static final String MAIN_IMAGES_CS_TOPICS_DIR = "cs_topics/";
    static final String MAIN_IMAGES_JAVA_FRAMEWORKS_DIR = "java_frameworks/";
    static final String MAIN_IMAGES_NAVIGATION_BTNS_DIR = "navigation_btns/";
    static final String MAIN_IMAGES_SOCIAL_MEDIA_DIR = "social_media/";
    static final String MAIN_IMAGES_LANGS_DIR = "langs/";
    static final String MAIN_IMAGES_MENUBAR_ICON_DIR = "menubar_icons/";

    final String imageName;
    final String imageExtension;
    final String imageDescription;
    final String imagePath;

    ImagesEnum(String imageName, String imageExtension, String imageDescription, String imagePath) {
        this.imageName = imageName;
        this.imageExtension = imageExtension;
        this.imageDescription = imageDescription;
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    @SuppressWarnings("unused")
    public String getImageExtension() {
        return imageExtension;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    @SuppressWarnings("unused")
    public String getImagePath() {
        return imagePath;
    }

    public String getImageFullName() {
        return imageName + imageExtension;
    }

    public String getImageFullNameWithPath() {
        return imagePath.endsWith("/") ? imagePath + getImageFullName() : imagePath + "/" + getImageFullName();
    }

    public static String getImageExtensionForName(String imageName) {
        return HelperClass.isStringNullOrEmpty(imageName) ? "" : getImagesEnumForName(imageName).imageExtension;
    }

    public static String getImageDescriptionForName(String imageName) {
        return HelperClass.isStringNullOrEmpty(imageName) ? "" : getImagesEnumForName(imageName).imageDescription;
    }

    @SuppressWarnings("unused")
    public static String getImageFullNameForName(String imageName) {
        return HelperClass.isStringNullOrEmpty(imageName) ? "" : imageName + getImageExtensionForName(imageName);
    }

    public static ImagesEnum getImagesEnumForName(String imageName) {
        return HelperClass.isStringNullOrEmpty(imageName) ? ImagesEnum.EMPTY_VALUE :
                Arrays.stream(ImagesEnum.values()).filter(image -> image.imageName.equals(imageName)).findAny().orElse(ImagesEnum.EMPTY_VALUE);
    }
}
