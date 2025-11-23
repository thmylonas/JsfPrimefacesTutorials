package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services._base.AbstractJsfJpaService;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services.InMemoryStudentService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "inMemoryJsfJpaService")
@SessionScoped
@Getter
@Setter
@Slf4j
public class InMemoryJsfJpaService extends AbstractJsfJpaService {

    @ManagedProperty(value = "#{inMemoryStudentService}")
    private InMemoryStudentService inMemoryStudentService;

    @PostConstruct
    private void init() {
        studentsFiltered = new ArrayList<>();
        saveFormStudent = new Student();
        updateFormStudent = new Student();
    }

    @Override
    public void findStudentById() {

        if (studentId == null || studentId < 0) {
            log.error("In-Memory Datasource: The id is not valid!");
            return;
        }
        // Reset the "studentsFiltered"
        studentsFiltered = new ArrayList<>();
        try {
            // Populate the "studentsFiltered" with the only 1 entry (to use it in the "h:dataTable", "p:dataTable")
            studentsFiltered.add(inMemoryStudentService.findStudentById(studentId));
        } catch (Exception e) {
            log.error("In-Memory Datasource: There is no student with id {}", studentId);
        }
    }

    @Override
    public List<Student> findAllStudents() {

        List<Student> allStudents = inMemoryStudentService.findAllStudents();
        if (HelperClass.isListNullOrEmpty(allStudents)) {
            log.error("In-Memory Datasource: There are no students");
            return Collections.emptyList();
        }
        return allStudents;
    }

    @Override
    public void saveNewStudent(Student student) {

        if (student == null || isStudentEmpty(student)) {
            log.error("In-Memory Datasource: The student is not valid (is null)!");
            return;
        }
        inMemoryStudentService.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student, Long id) {

        if (id == null || id < 0 || student == null || isStudentEmpty(student)) {
            log.error("In-Memory Datasource: The arguments are not valid!");
            return;
        }
        try {
            inMemoryStudentService.updateStudent(student, id);
        } catch (Exception e) {
            log.error("In-Memory Datasource: There is no student with id {}, to update", id);
        }
    }

    @Override
    public void deleteStudent() {

        if (deleteFormStudentId == null || deleteFormStudentId < 0) {
            log.error("In-Memory Datasource: The id is not valid!");
            return;
        }
        inMemoryStudentService.deleteStudent(deleteFormStudentId);
    }
}
