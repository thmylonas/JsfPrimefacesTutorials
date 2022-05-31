package com.thomasmylonas.my_spring_hibernate_jsf_web_app.config;

import javax.naming.NamingException;
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

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        //emfb.setPersistenceUnitName("School_PU");
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        //properties.put("hibernate.id.new_generator_mappings", "true");
        emfb.setJpaProperties(properties);

        emfb.setPackagesToScan("com.thomasmylonas.my_spring_hibernate_jsf_web_app");
        return emfb;
    }

    @Bean
    public DataSource dataSource() {

        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/oracledb");
        jndiObjectFactoryBean.setResourceRef(true); // Default value: false
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        try {
            jndiObjectFactoryBean.afterPropertiesSet();
        } catch (NamingException e) {
            LOGGER.error("NamingException thrown while jndiObjectFactoryBean.afterPropertiesSet");
        }
        return (DataSource) jndiObjectFactoryBean.getObject();
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
}
