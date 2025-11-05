package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.ResourceNotFoundException;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services._base.AbstractJsfJpaService;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services.InMemoryStudentService;
import lombok.Getter;
import lombok.Setter;

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
            LOGGER.error("There are no students");
            return Collections.emptyList();
        }
        return allStudents;
    }

    public void saveNewStudent(Student student) {

        if (isStudentEmpty(student)) {
            return;
        }
        List<Student> allStudentsList = findAllStudents();
        if (HelperClass.isListNullOrEmpty(allStudentsList)) {
            student.setId(1L);
        } else {
            student.setId((long) (allStudentsList.size()));
        }
        inMemoryStudentService.saveStudent(student);
    }

    public void updateStudent(Student student, Long id) {

        if (id == null || isStudentEmpty(student)) {
            return;
        }
        try {
            inMemoryStudentService.updateStudent(student, id);
        } catch (ResourceNotFoundException e) {
            LOGGER.error("There is no student with id {}, to update", id);
        }
    }

    public void deleteStudent() {

        if (deleteFormStudentId == null) {
            return;
        }
        try {
            inMemoryStudentService.deleteStudent(deleteFormStudentId);
        } catch (ResourceNotFoundException e) {
            LOGGER.error("There is no student with id {}, to delete", deleteFormStudentId);
        }
    }
}
