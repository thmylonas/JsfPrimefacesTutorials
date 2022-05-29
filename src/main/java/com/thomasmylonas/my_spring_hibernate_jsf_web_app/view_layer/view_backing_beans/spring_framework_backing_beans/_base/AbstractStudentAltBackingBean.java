package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAltModel;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;

import java.util.List;

public abstract class AbstractStudentAltBackingBean extends AbstractBackingBean {

    protected List<StudentAlt> studentsAltFilteredList;
    protected Long studentAltId;
    protected Long studentAltToUpdateId;
    protected Long studentAltToDeleteId;
    protected StudentAltModel studentAltToSaveModel;
    protected StudentAltModel studentAltToUpdateModel;

    protected boolean isStudentAltModelEmpty(StudentAltModel studentAltModel) {
        return HelperClass.isStringNullOrEmpty(studentAltModel.getLastName()) &&
                HelperClass.isStringNullOrEmpty(studentAltModel.getFirstName()) &&
                studentAltModel.getDateOfBirth() == null &&
                studentAltModel.getAbsences() == null &&
                HelperClass.isStringNullOrEmpty(studentAltModel.getDepartmentId()) &&
                HelperClass.isStringNullOrEmpty(studentAltModel.getStatus().getValue());
    }

    protected void resetStudentAltModel(StudentAltModel studentAltModel) {
        studentAltModel.setLastName(null);
        studentAltModel.setFirstName(null);
        studentAltModel.setDateOfBirth(null);
        studentAltModel.setAbsences(null);
        studentAltModel.setDepartmentId(null);
        studentAltModel.setStatus(null);
    }

    public List<StudentAlt> getStudentsAltFilteredList() {
        return studentsAltFilteredList;
    }

    public void setStudentsAltFilteredList(List<StudentAlt> studentsAltFilteredList) {
        this.studentsAltFilteredList = studentsAltFilteredList;
    }

    public Long getStudentAltId() {
        return studentAltId;
    }

    public void setStudentAltId(Long studentAltId) {
        this.studentAltId = studentAltId;
    }

    public Long getStudentAltToUpdateId() {
        return studentAltToUpdateId;
    }

    public void setStudentAltToUpdateId(Long studentAltToUpdateId) {
        this.studentAltToUpdateId = studentAltToUpdateId;
    }

    public Long getStudentAltToDeleteId() {
        return studentAltToDeleteId;
    }

    public void setStudentAltToDeleteId(Long studentAltToDeleteId) {
        this.studentAltToDeleteId = studentAltToDeleteId;
    }

    public StudentAltModel getStudentAltToSaveModel() {
        return studentAltToSaveModel;
    }

    public void setStudentAltToSaveModel(StudentAltModel studentAltToSaveModel) {
        this.studentAltToSaveModel = studentAltToSaveModel;
    }

    public StudentAltModel getStudentAltToUpdateModel() {
        return studentAltToUpdateModel;
    }

    public void setStudentAltToUpdateModel(StudentAltModel studentAltToUpdateModel) {
        this.studentAltToUpdateModel = studentAltToUpdateModel;
    }
}
