package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.exceptions.ResourceNotFoundException;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services.StudentAltService;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base.StudentAltBackingBean;

import java.util.ArrayList;
import java.util.List;

//@Component(value = "inMemoryStudentAltBackingBean")
public class InMemoryStudentAltBackingBean extends StudentAltBackingBean {

    private final StudentAltService inMemoryStudentAltService;

//    @Autowired
    public InMemoryStudentAltBackingBean(StudentAltService inMemoryStudentAltService) {
        this.inMemoryStudentAltService = inMemoryStudentAltService;
        studentsAltFilteredList = new ArrayList<>();
        saveFormStudentAlt = new StudentAlt();
        updateFormStudentAlt = new StudentAlt();
    }

    public void displayStudentAltById() {
        // Reset the "studentsAltFilteredList"
        studentsAltFilteredList = new ArrayList<>();
        // Populate the "studentsAltFilteredList" with the only 1 entry (to use it in the "h:dataTable", "p:dataTable")
        studentsAltFilteredList.add(inMemoryStudentAltService.getStudentAltById(studentAltId));
    }

    public List<StudentAlt> fetchAllStudentsAlt() {

        List<StudentAlt> allStudentsAltList = inMemoryStudentAltService.getAllStudentsAlt();
        if (HelperClass.isListNullOrEmpty(allStudentsAltList)) {
            // Display error message (somehow)
        }
        return allStudentsAltList;
    }

    public void saveNewStudentAlt(StudentAlt studentAlt) {

        if (isStudentAltEmpty(studentAlt)) {
            return;
        }
        List<StudentAlt> allStudentsAltList = fetchAllStudentsAlt();
        if (HelperClass.isListNullOrEmpty(allStudentsAltList)) {
            studentAlt.setId(1L);
        } else {
            studentAlt.setId((long) allStudentsAltList.size());
        }
        inMemoryStudentAltService.saveStudentAlt(studentAlt);
    }

    public void updateStudentAlt(StudentAlt studentAlt, Long id) {

        if (id == null || isStudentAltEmpty(studentAlt)) {
            return;
        }
        try {
            inMemoryStudentAltService.updateStudentAlt(studentAlt, id);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public void deleteStudentAlt() {
        try {
            inMemoryStudentAltService.deleteStudentAlt(deleteFormStudentAltId);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }
}
