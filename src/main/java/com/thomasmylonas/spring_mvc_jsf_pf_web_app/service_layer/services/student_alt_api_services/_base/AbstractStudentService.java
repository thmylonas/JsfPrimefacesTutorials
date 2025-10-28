package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.Student;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services._base.AbstractService;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services.StudentService;

public abstract class AbstractStudentService extends AbstractService implements StudentService {

    // All "interface StudentService"'s methods are implemented in the subclasses

    protected void updateStudentWithGivenObject(Student studentToBeUpdated, Student student) {

        if (studentToBeUpdated == null || student == null) {
            return;
        }
        if (!HelperClass.isStringNullOrEmpty(student.getLastName())) {
            studentToBeUpdated.setLastName(student.getLastName());
        }
        if (!HelperClass.isStringNullOrEmpty(student.getFirstName())) {
            studentToBeUpdated.setFirstName(student.getFirstName());
        }
        if (student.getDateOfBirth() != null) {
            studentToBeUpdated.setDateOfBirth(student.getDateOfBirth());
        }
        if (student.getAbsences() != null) {
            studentToBeUpdated.setAbsences(student.getAbsences());
        }
        if (!HelperClass.isStringNullOrEmpty(student.getDepartmentId())) {
            studentToBeUpdated.setDepartmentId(student.getDepartmentId());
        }
        if (student.getStatus() != null) {
            studentToBeUpdated.setStatus(student.getStatus());
        }
    }
}
