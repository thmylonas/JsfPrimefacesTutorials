package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.spring_framework_models.StudentAltModel;
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
        studentsAltFilteredList = new ArrayList<>(); // TODO: Temp code
        studentAltToSaveModel = new StudentAltModel();
        studentAltToUpdateModel = new StudentAltModel();
    }

    public void displayStudentAltById() {

        // TODO: Temp code
        studentsAltFilteredList = new ArrayList<>();
//        studentsAltFilteredList.add(new StudentAlt.Builder()
//                .id(999L).lastName("Aaaa")
//                .firstName("Bbbb")
//                .dateOfBirth(HelperClass.getDate(2000, Calendar.APRIL, 1))
//                .absences(999)
//                .departmentId("ddd")
//                .status(Status.ADVANCED_STUDENT)
//                .build());
    }

    public List<StudentAlt> fetchAllStudentsAlt() {
        // TODO: Temp code
        return studentsAltFilteredList;
    }

    public void saveNewStudentAlt(StudentAltModel studentAltModel) {

        // TODO: Add code
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

        dbStudentAltService.saveStudentAlt(studentAlt);
    }

    public void updateStudentAlt(StudentAltModel studentAltModel, Integer id) {
        // TODO: Add code
    }

    public void deleteStudentAlt() {
        // TODO: Add code
    }

    public void resetFetchByIdForm() {
        // TODO: Add code
    }

    public void resetSaveForm() {
        // TODO: Add code
    }

    public void resetUpdateForm() {
        // TODO: Add code
    }

    public void resetDeleteForm() {
        // TODO: Add code
    }
}
