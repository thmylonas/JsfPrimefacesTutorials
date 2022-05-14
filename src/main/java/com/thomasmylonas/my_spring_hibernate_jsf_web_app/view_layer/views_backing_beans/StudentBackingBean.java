package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.views_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.repositories.StudentAltRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StudentBackingBean {

    @Autowired
    private StudentAltRepository studentAltRepository;

    private Integer id;
    private String firstName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private Date dateOfBirth;
    private Integer absences;
    private Integer departmentId;

    public StudentBackingBean() {
//        this.id = studentAltRepository.getOne(1).getId();
//        this.firstName = studentAltRepository.getOne(1).getFirstName();
//        this.lastName = studentAltRepository.getOne(1).getLastName();
//        this.motherName = studentAltRepository.getOne(1).getMotherName();
//        this.fatherName = studentAltRepository.getOne(1).getFatherName();
//        this.dateOfBirth = studentAltRepository.getOne(1).getDateOfBirth();
//        this.absences = studentAltRepository.getOne(1).getAbsences();
//        this.departmentId = studentAltRepository.getOne(1).getDepartmentId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAbsences() {
        return absences;
    }

    public void setAbsences(Integer absences) {
        this.absences = absences;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
