package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.RequestedResourceNotFoundException;
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

    public void findStudentById() {

        if (studentId == null) {
            return;
        }
        // Reset the "studentsFiltered"
        studentsFiltered = new ArrayList<>();
        // Populate the "studentsFiltered" with the only 1 entry (to use it in the "h:dataTable", "p:dataTable")
        studentsFiltered.add(inMemoryStudentService.findStudentById(studentId));
    }

    public List<Student> findAllStudents() {

        List<Student> allStudents = inMemoryStudentService.findAllStudents();
        if (HelperClass.isListNullOrEmpty(allStudents)) {
            log.error("There are no students");
            return Collections.emptyList();
        }
        return allStudents;
    }

    public void saveNewStudent(Student student) {

        if (isStudentEmpty(student)) {
            return;
        }
        inMemoryStudentService.saveStudent(student);
    }

    public void updateStudent(Student student, Long id) {

        if (id == null || isStudentEmpty(student)) {
            return;
        }
        try {
            inMemoryStudentService.updateStudent(student, id);
        } catch (RequestedResourceNotFoundException e) {
            log.error("There is no student with id {}, to update", id);
        }
    }

    public void deleteStudent() {

        if (deleteFormStudentId == null) {
            return;
        }
        try {
            inMemoryStudentService.deleteStudent(deleteFormStudentId);
        } catch (RequestedResourceNotFoundException e) {
            log.error("There is no student with id {}, to delete", deleteFormStudentId);
        }
    }
}
