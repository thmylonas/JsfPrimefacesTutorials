package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component(value = "studentAltBackingBean")
public class StudentAltBackingBean implements Serializable {

    private Long studentId;
    private final StudentAltService inMemoryStudentAltService;
    private final StudentAltService dbStudentAltService;

    private List<StudentAlt> inMemoryStudentsAltFilteredList;

    @Autowired
    public StudentAltBackingBean(StudentAltService inMemoryStudentAltService, StudentAltService dbStudentAltService) {
        this.inMemoryStudentAltService = inMemoryStudentAltService;
        this.dbStudentAltService = dbStudentAltService;
        inMemoryStudentsAltFilteredList = new ArrayList<>();
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public StudentAltService getInMemoryStudentAltService() {
        return inMemoryStudentAltService;
    }

    public StudentAltService getDbStudentAltService() {
        return dbStudentAltService;
    }

    public void displayStudentAltByGivenId() {
        inMemoryStudentsAltFilteredList.add(inMemoryStudentAltService.getStudentAltById(studentId));
    }

    public List<StudentAlt> getAllStudentsAltList() {
        return inMemoryStudentAltService.getAllStudentsAlt();
    }

    public void resetFormWhichGetsStudentAltById() {
        inMemoryStudentsAltFilteredList = new ArrayList<>();
        studentId = null;
    }

    public List<StudentAlt> getInMemoryStudentsAltFilteredList() {
        return inMemoryStudentsAltFilteredList;
    }
}
