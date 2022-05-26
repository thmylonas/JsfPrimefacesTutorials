package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAltModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component(value = "studentAltBackingBean")
public class StudentAltBackingBean implements Serializable {

    private Long studentId;
    private Long studentToDeleteId;
    private StudentAltModel studentAltModel;
    private final StudentAltService inMemoryStudentAltService;
    private final StudentAltService dbStudentAltService;

    private List<StudentAlt> inMemoryStudentsAltFilteredList;

    @Autowired
    public StudentAltBackingBean(StudentAltService inMemoryStudentAltService, StudentAltService dbStudentAltService) {
        this.inMemoryStudentAltService = inMemoryStudentAltService;
        this.dbStudentAltService = dbStudentAltService;
        inMemoryStudentsAltFilteredList = new ArrayList<>();
        studentAltModel = new StudentAltModel();
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentToDeleteId() {
        return studentToDeleteId;
    }

    public void setStudentToDeleteId(Long studentToDeleteId) {
        this.studentToDeleteId = studentToDeleteId;
    }

    public StudentAltModel getStudentAltModel() {
        return studentAltModel;
    }

    public void setStudentAltModel(StudentAltModel studentAltModel) {
        this.studentAltModel = studentAltModel;
    }

    public void setInMemoryStudentsAltFilteredList(List<StudentAlt> inMemoryStudentsAltFilteredList) {
        this.inMemoryStudentsAltFilteredList = inMemoryStudentsAltFilteredList;
    }

    public StudentAltService getInMemoryStudentAltService() {
        return inMemoryStudentAltService;
    }

    public StudentAltService getDbStudentAltService() {
        return dbStudentAltService;
    }

    public void displayStudentAltByGivenId() {
        inMemoryStudentsAltFilteredList = new ArrayList<>();
        inMemoryStudentsAltFilteredList.add(inMemoryStudentAltService.getStudentAltById(studentId));
    }

    public void postNewStudentAlt(StudentAltModel studentAltModel) {

        StudentAlt studentAlt = new StudentAlt();

        studentAlt.setId((long) inMemoryStudentAltService.getAllStudentsAlt().size() + 1);
        studentAlt.setFirstName(studentAltModel.getFirstName());
        studentAlt.setLastName(studentAltModel.getLastName());
        studentAlt.setDateOfBirth(studentAltModel.getDateOfBirth());
        studentAlt.setAbsences(studentAltModel.getAbsences());
        studentAlt.setDepartmentId(studentAltModel.getDepartmentId());
        studentAlt.setStatus(studentAltModel.getStatus());
        
        inMemoryStudentAltService.getAllStudentsAlt().add(studentAlt);
    }

    public void deleteStudentAltByGivenId() {
        inMemoryStudentAltService.getAllStudentsAlt().remove(inMemoryStudentAltService.getStudentAltById(studentToDeleteId));
    }

    public List<StudentAlt> getAllStudentsAltList() {
        return inMemoryStudentAltService.getAllStudentsAlt();
    }

    public void resetFormWhichGetsStudentAltById() {
        inMemoryStudentsAltFilteredList = new ArrayList<>();
        studentId = null;
    }

    public void resetFormWhichDeletesStudentAltById() {
        studentToDeleteId = null;
    }

    public List<StudentAlt> getInMemoryStudentsAltFilteredList() {
        return inMemoryStudentsAltFilteredList;
    }
}
