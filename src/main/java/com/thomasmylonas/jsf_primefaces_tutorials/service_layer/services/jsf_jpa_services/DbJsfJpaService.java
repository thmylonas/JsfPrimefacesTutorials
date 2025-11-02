package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.ResourceNotFoundException;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services._base.AbstractJsfJpaService;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services.DbStudentService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "dbJsfJpaService")
@ViewScoped
@Getter
@Setter
public class DbJsfJpaService extends AbstractJsfJpaService {

    @ManagedProperty(value = "#{dbStudentService}")
    private DbStudentService dbStudentService;

    @PostConstruct
    private void init() {
        studentsFilteredList = new ArrayList<>();
        saveFormStudent = new Student();
        updateFormStudent = new Student();
    }

    public void displayStudentById() {

        if (studentId == null) {
            return;
        }
        // Reset the "studentsFilteredList"
        studentsFilteredList = new ArrayList<>();
        // Populate the "studentsFilteredList" with the only 1 entry (to use it in the "h:dataTable", "p:dataTable")
        try {
            studentsFilteredList.add(dbStudentService.getStudentById(studentId));
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public List<Student> fetchAllStudents() {

        List<Student> allStudentsList = dbStudentService.getAllStudents();
        if (HelperClass.isListNullOrEmpty(allStudentsList)) {
            // Display error message (somehow)
            return Collections.emptyList();
        }
        return allStudentsList;
    }

    public void saveNewStudent(Student student) {

        if (isStudentEmpty(student)) {
            return;
        }
        dbStudentService.saveStudent(student);
    }

    public void updateStudent(Student student, Long id) {

        if (id == null || isStudentEmpty(student)) {
            return;
        }
        try {
            dbStudentService.updateStudent(student, id);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public void deleteStudent() {

        if (deleteFormStudentId == null) {
            return;
        }
        try {
            dbStudentService.deleteStudent(deleteFormStudentId);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }
}
