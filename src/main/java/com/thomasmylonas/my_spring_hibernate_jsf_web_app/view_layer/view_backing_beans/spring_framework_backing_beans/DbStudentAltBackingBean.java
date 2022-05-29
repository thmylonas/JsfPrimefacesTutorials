package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAltModel;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.student_alt_api_services.StudentAltService;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base.AbstractStudentAltBackingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "dbStudentAltBackingBean")
public class DbStudentAltBackingBean extends AbstractStudentAltBackingBean {

    private final StudentAltService dbStudentAltService;

    @Autowired
    public DbStudentAltBackingBean(StudentAltService dbStudentAltService) {
        this.dbStudentAltService = dbStudentAltService;
        studentAltToSaveModel = new StudentAltModel();
        studentAltToUpdateModel = new StudentAltModel();
    }

    // ...
}
