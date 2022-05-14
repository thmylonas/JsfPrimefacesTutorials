package com.thomasmylonas.my_spring_hibernate_jsf_web_app.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.thomasmylonas.my_spring_hibernate_jsf_web_app"})
public class DataAccessConfig {

    private final Logger LOGGER = LogManager.getLogger(getClass().getName());

    /**
     * Not used bean: If we try to call "FactoryBean::getObject" in the code, it might return a "null" bean, according to the
     * link: "https://coderedirect.com/questions/452837/why-does-a-springs-factorybean-getobject-return-null"
     *
     * @param dataSource       A factory for connections to the physical data source that this DataSource object represents
     * @param jpaVendorAdapter JpaVendorAdapter allows to plug in a specific vendor (e.g. Hibernate) into Spring's EntityManagerFactory
     * @return The EntityManagerFactoryBean
     */
    @Deprecated
    //@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        //emfb.setPersistenceUnitName("School_PU");
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);

        Properties properties = new Properties();
        /*
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.id.new_generator_mappings", "true");
        */
        emfb.setJpaProperties(properties);

        emfb.setPackagesToScan("com.thomasmylonas.my_spring_hibernate_jsf_web_app");
        return emfb;
    }

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);

        Properties properties = new Properties();
        /*
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.id.new_generator_mappings", "true");
        */
        emfb.setJpaProperties(properties);

        emfb.setPackagesToScan("com.thomasmylonas.my_spring_hibernate_jsf_web_app");
        emfb.afterPropertiesSet(); // Mandatory so the "FactoryBean::getObject" will return a "not null" bean
        return emfb.getObject();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.ORACLE);
        adapter.setDatabasePlatform("org.hibernate.dialect.Oracle12cDialect");
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        return adapter;
    }

    @Bean
    public DataSource dataSource() {

        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/oracledb"); // Alternative name: "java:comp/env/jdbc/oracledb"
        jndiObjectFactoryBean.setResourceRef(true); // Default value: false
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        //jndiObjectFactoryBean.setLookupOnStartup(false); // Default value: true
        try {
            jndiObjectFactoryBean.afterPropertiesSet();
        } catch (NamingException e) {
            LOGGER.error("NamingException thrown while jndiObjectFactoryBean.afterPropertiesSet");
        }
        return (DataSource) jndiObjectFactoryBean.getObject();
    }

    /**
     * Alternative solutions for retrieving DataSource via JNDI
     *
     * @return A factory for connections to the physical data source that this DataSource object represents
     */
    //@Bean
    DataSource dataSourceViaJndi() {

        Context initContext = null;
        DataSource ds = null;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/oracledb");
            //ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/oracledb"); // Alternatively
        } catch (NamingException e) {
            LOGGER.error("NamingException thrown while lookup with JNDI");
        }
        return ds;
    }

    /**
     * Alternative solutions for retrieving DataSource via JNDI & Environment
     *
     * @return A factory for connections to the physical data source that this DataSource object represents
     */
    //@Bean
    public DataSource dataSourceViaJndiEnv() {

        Properties env = new Properties();
        /*
        env.put(Context.INITIAL_CONTEXT_FACTORY, org.apache.naming.java.javaURLContextFactory.class.getName());
        env.put(Context.PROVIDER_URL, "localhost:8080");
        */
        env.put(Context.INITIAL_CONTEXT_FACTORY, com.sun.jndi.rmi.registry.RegistryContextFactory.class.getName());
        env.put(Context.PROVIDER_URL, "rmi://localhost:8080");

        Context initContext;
        DataSource ds = null;
        try {
            initContext = new InitialContext(env);
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/oracledb");
        } catch (NamingException e) {
            LOGGER.error("NamingException thrown while lookup with JNDI");
        }
        return ds;
    }
}
