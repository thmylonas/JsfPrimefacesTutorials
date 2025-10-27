package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._general_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.models._general_models.JavaFrameworksModel;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Component(value = "javaFrameworksBackingBean")
//@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JavaFrameworksBackingBean extends AbstractBackingBean {

    private List<JavaFrameworksModel> javaFrameworks;

    @PostConstruct
    private void init() {
        javaFrameworks = new ArrayList<>();
        javaFrameworks.add(new JavaFrameworksModel("1", "JAXB", "Java SE"));
        javaFrameworks.add(new JavaFrameworksModel("2", "JDBC", "Java SE"));
        javaFrameworks.add(new JavaFrameworksModel("3", "Spring Framework", "Java EE"));
        javaFrameworks.add(new JavaFrameworksModel("4", "Hibernate", "Java EE"));
        javaFrameworks.add(new JavaFrameworksModel("5", "JavaServer Faces", "Java EE"));
        javaFrameworks.add(new JavaFrameworksModel("6", "Primefaces", "Java EE"));
    }

    public List<JavaFrameworksModel> getJavaFrameworks() {
        return javaFrameworks;
    }
}
