package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.RequestedResourceNotFoundException;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services._base.AbstractJsfJpaService;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services.DbStudentService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "dbJsfJpaService")
@SessionScoped
@Getter
@Setter
@Slf4j
public class DbJsfJpaService extends AbstractJsfJpaService {

    @ManagedProperty(value = "#{dbStudentService}")
    private DbStudentService dbStudentService;

    @PostConstruct
    private void init() {
        studentsFiltered = new ArrayList<>();
        saveFormStudent = new Student();
        updateFormStudent = new Student();
    }

    @Override
    public void findStudentById() {

        if (studentId == null || studentId < 0) {
            log.error("Database Datasource: The id is not valid!");
            return;
        }
        // Reset the "studentsFiltered"
        studentsFiltered = new ArrayList<>();
        try {
            // Populate the "studentsFiltered" with the only 1 entry (to use it in the "h:dataTable", "p:dataTable")
            studentsFiltered.add(dbStudentService.findStudentById(studentId)); // IllegalArgumentException, RequestedResourceNotFoundException
        } catch (RequestedResourceNotFoundException e) {
            log.error(noStudentWithIdMessage("Datasource", "{}", "find"), studentId);
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "Student not found!", noStudentWithIdMessage("Datasource", String.valueOf(studentId), "find"));
        } catch (IllegalArgumentException e) {
            log.error(inputDataNotValidMessage("{}"), e.getMessage());
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "Input validation error!", inputDataNotValidMessage(e.getMessage()));
        } catch (Exception e) {
            log.error(failureMessage("{}"), e.getMessage());
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "General failure!", failureMessage(e.getMessage()));
        }
    }

    @Override
    public List<Student> findAllStudents() {

        List<Student> allStudents = dbStudentService.findAllStudents();
        if (HelperClass.isListNullOrEmpty(allStudents)) {
            log.error("Database Datasource: There are no students");
            return Collections.emptyList();
        }
        return allStudents;
    }

    @Override
    public void saveNewStudent(Student student) {

        if (student == null || isStudentEmpty(student)) {
            log.error("Database Datasource: The student is not valid (is null)!");
            return;
        }
        try {
            dbStudentService.saveStudent(student); // IllegalArgumentException, GeneralRollbackException
        } catch (IllegalArgumentException e) {
            log.error(inputDataNotValidMessage("{}"), e.getMessage());
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "Input validation error!", inputDataNotValidMessage(e.getMessage()));
        } catch (Exception e) {
            log.error(failureMessage("{}"), e.getMessage());
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "General failure!", failureMessage(e.getMessage()));
        }
    }

    @Override
    public void updateStudent(Student student, Long id) {

        if (id == null || id < 0 || student == null || isStudentEmpty(student)) {
            log.error("Database Datasource: The arguments are not valid!");
            return;
        }
        try {
            dbStudentService.updateStudent(student, id); // IllegalArgumentException, RequestedResourceNotFoundException, GeneralRollbackException
        } catch (RequestedResourceNotFoundException e) {
            log.error(noStudentWithIdMessage("Datasource", "{}", "update"), id);
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "Student not found!", noStudentWithIdMessage("Datasource", String.valueOf(id), "update"));
        } catch (IllegalArgumentException e) {
            log.error(inputDataNotValidMessage("{}"), e.getMessage());
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "Input validation error!", inputDataNotValidMessage(e.getMessage()));
        } catch (Exception e) {
            log.error(failureMessage("{}"), e.getMessage());
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "General failure!", failureMessage(e.getMessage()));
        }
    }

    @Override
    public void deleteStudent() {

        if (deleteFormStudentId == null || deleteFormStudentId < 0) {
            log.error("Database Datasource: The id is not valid!");
            return;
        }
        try {
            dbStudentService.deleteStudent(deleteFormStudentId); // IllegalArgumentException, RequestedResourceNotFoundException, GeneralRollbackException
        } catch (RequestedResourceNotFoundException e) {
            log.error(noStudentWithIdMessage("Datasource", "{}", "delete"), deleteFormStudentId);
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "Student not found!", noStudentWithIdMessage("Datasource", String.valueOf(deleteFormStudentId), "delete"));
        } catch (IllegalArgumentException e) {
            log.error(inputDataNotValidMessage("{}"), e.getMessage());
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "Input validation error!", inputDataNotValidMessage(e.getMessage()));
        } catch (Exception e) {
            log.error(failureMessage("{}"), e.getMessage());
            displayFacesMessage(FacesMessage.SEVERITY_ERROR, "General failure!", failureMessage(e.getMessage()));
        }
    }
}
