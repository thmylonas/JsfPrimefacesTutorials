package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.student_alt_api_services._base;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services._base.AbstractService;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.student_alt_api_services.StudentAltService;

public abstract class AbstractStudentAltService extends AbstractService implements StudentAltService {

    // All "interface StudentAltService"'s methods are implemented in the subclasses

    protected void updateStudentAltWithGivenObject(StudentAlt studentAltToUpdate, StudentAlt studentAlt) {

        if (studentAltToUpdate == null || studentAlt == null) {
            return;
        }
        if (!HelperClass.isStringNullOrEmpty(studentAlt.getLastName())) {
            studentAltToUpdate.setLastName(studentAlt.getLastName());
        }
        if (!HelperClass.isStringNullOrEmpty(studentAlt.getFirstName())) {
            studentAltToUpdate.setFirstName(studentAlt.getFirstName());
        }
        if (studentAlt.getDateOfBirth() != null) {
            studentAltToUpdate.setDateOfBirth(studentAlt.getDateOfBirth());
        }
        if (studentAlt.getAbsences() != null) {
            studentAltToUpdate.setAbsences(studentAlt.getAbsences());
        }
        if (!HelperClass.isStringNullOrEmpty(studentAlt.getDepartmentId())) {
            studentAltToUpdate.setDepartmentId(studentAlt.getDepartmentId());
        }
        if (!HelperClass.isStringNullOrEmpty(studentAlt.getStatus().getValue())) {
            studentAltToUpdate.setStatus(studentAlt.getStatus());
        }
    }
}
