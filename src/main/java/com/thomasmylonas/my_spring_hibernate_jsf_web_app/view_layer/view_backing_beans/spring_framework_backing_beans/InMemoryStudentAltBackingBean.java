package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.spring_framework_models.StudentAltModel;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions.ResourceNotFoundException;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.student_alt_api_services.StudentAltService;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base.StudentAltBackingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "inMemoryStudentAltBackingBean")
public class InMemoryStudentAltBackingBean extends StudentAltBackingBean {

    private final StudentAltService inMemoryStudentAltService;

    @Autowired
    public InMemoryStudentAltBackingBean(StudentAltService inMemoryStudentAltService) {
        this.inMemoryStudentAltService = inMemoryStudentAltService;
        studentsAltFilteredList = new ArrayList<>();
        studentAltToSaveModel = new StudentAltModel();
        studentAltToUpdateModel = new StudentAltModel();
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

    public void saveNewStudentAlt(StudentAltModel studentAltModel) {

        if (isStudentAltModelEmpty(studentAltModel)) {
            return;
        }
        StudentAlt studentAlt = new StudentAlt();

        List<StudentAlt> allStudentsAltList = fetchAllStudentsAlt();
        if (HelperClass.isListNullOrEmpty(allStudentsAltList)) {
            studentAlt.setId(0L);
        } else {
            studentAlt.setId((long) allStudentsAltList.size());
        }
        studentAlt.setLastName(studentAltModel.getLastName());
        studentAlt.setFirstName(studentAltModel.getFirstName());
        studentAlt.setDateOfBirth(studentAltModel.getDateOfBirth());
        studentAlt.setAbsences(studentAltModel.getAbsences());
        studentAlt.setDepartmentId(studentAltModel.getDepartmentId());
        studentAlt.setStatus(studentAltModel.getStatus());

        inMemoryStudentAltService.saveStudentAlt(studentAlt);
    }

    public void updateStudentAlt(StudentAltModel studentAltModel, Integer id) {

        if (id == null || isStudentAltModelEmpty(studentAltModel)) {
            return;
        }
        StudentAlt studentAlt = new StudentAlt();

        studentAlt.setLastName(studentAltModel.getLastName());
        studentAlt.setFirstName(studentAltModel.getFirstName());
        studentAlt.setDateOfBirth(studentAltModel.getDateOfBirth());
        studentAlt.setAbsences(studentAltModel.getAbsences());
        studentAlt.setDepartmentId(studentAltModel.getDepartmentId());
        studentAlt.setStatus(studentAltModel.getStatus());

        try {
            inMemoryStudentAltService.updateStudentAlt(studentAlt, id.longValue());
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public void deleteStudentAlt() {
        try {
            inMemoryStudentAltService.deleteStudentAlt(studentAltToDeleteId);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public void resetFetchByIdForm() {
        studentsAltFilteredList = new ArrayList<>();
        studentAltId = null;
    }

    public void resetSaveForm() {
        resetStudentAltModel(studentAltToSaveModel);
    }

    public void resetUpdateForm() {
        studentAltToUpdateId = null;
        resetStudentAltModel(studentAltToUpdateModel);
    }

    public void resetDeleteForm() {
        studentAltToDeleteId = null;
    }
}
