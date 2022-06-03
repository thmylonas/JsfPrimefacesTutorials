package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions.ResourceNotFoundException;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.student_alt_api_services.StudentAltService;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base.StudentAltBackingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "dbStudentAltBackingBean")
public class DbStudentAltBackingBean extends StudentAltBackingBean {

    private final StudentAltService dbStudentAltService;

    @Autowired
    public DbStudentAltBackingBean(StudentAltService dbStudentAltService) {
        this.dbStudentAltService = dbStudentAltService;
        studentsAltFilteredList = new ArrayList<>();
        saveFormStudentAlt = new StudentAlt();
        updateFormStudentAlt = new StudentAlt();
    }

    public void displayStudentAltById() {

        if (studentAltId == null) {
            return;
        }
        // Reset the "studentsAltFilteredList"
        studentsAltFilteredList = new ArrayList<>();
        // Populate the "studentsAltFilteredList" with the only 1 entry (to use it in the "h:dataTable", "p:dataTable")
        try {
            studentsAltFilteredList.add(dbStudentAltService.getStudentAltById(studentAltId));
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public List<StudentAlt> fetchAllStudentsAlt() {

        List<StudentAlt> allStudentsAltList = dbStudentAltService.getAllStudentsAlt();
        if (HelperClass.isListNullOrEmpty(allStudentsAltList)) {
            // Display error message (somehow)
        }
        return allStudentsAltList;
    }

    public void saveNewStudentAlt(StudentAlt studentAlt) {

        if (isStudentAltEmpty(studentAlt)) {
            return;
        }
        dbStudentAltService.saveStudentAlt(studentAlt);
    }

    public void updateStudentAlt(StudentAlt studentAlt, Long id) {

        if (id == null || isStudentAltEmpty(studentAlt)) {
            return;
        }
        try {
            dbStudentAltService.updateStudentAlt(studentAlt, id);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public void deleteStudentAlt() {

        if (deleteFormStudentAltId == null) {
            return;
        }
        try {
            dbStudentAltService.deleteStudentAlt(deleteFormStudentAltId);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }
}
