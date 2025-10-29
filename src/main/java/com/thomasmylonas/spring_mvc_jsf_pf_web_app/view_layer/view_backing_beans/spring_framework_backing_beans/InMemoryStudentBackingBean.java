package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.Student;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.exceptions.ResourceNotFoundException;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services.InMemoryStudentService;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services.StudentService;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base.StudentBackingBean;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "inMemoryStudentBackingBean")
public class InMemoryStudentBackingBean extends StudentBackingBean {

    private final StudentService inMemoryStudentService;

    public InMemoryStudentBackingBean() {

        inMemoryStudentService = new InMemoryStudentService();

        studentsFilteredList = new ArrayList<>();
        saveFormStudent = new Student();
        updateFormStudent = new Student();
    }

    public void displayStudentById() {
        // Reset the "studentsFilteredList"
        studentsFilteredList = new ArrayList<>();
        // Populate the "studentsFilteredList" with the only 1 entry (to use it in the "h:dataTable", "p:dataTable")
        studentsFilteredList.add(inMemoryStudentService.getStudentById(studentId));
    }

    public List<Student> fetchAllStudents() {

        List<Student> allStudentsList = inMemoryStudentService.getAllStudents();
        if (HelperClass.isListNullOrEmpty(allStudentsList)) {
            // Display error message (somehow)
        }
        return allStudentsList;
    }

    public void saveNewStudent(Student student) {

        if (isStudentEmpty(student)) {
            return;
        }
        List<Student> allStudentsList = fetchAllStudents();
        if (HelperClass.isListNullOrEmpty(allStudentsList)) {
            student.setId(1L);
        } else {
            student.setId((long) allStudentsList.size());
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
            // Display error message (somehow)
        }
    }

    public void deleteStudent() {
        try {
            inMemoryStudentService.deleteStudent(deleteFormStudentId);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }
}
