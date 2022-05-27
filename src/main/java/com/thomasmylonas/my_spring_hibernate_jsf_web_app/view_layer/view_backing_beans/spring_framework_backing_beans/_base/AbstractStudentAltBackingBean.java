package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAltModel;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;

import java.util.List;

public abstract class AbstractStudentAltBackingBean extends AbstractBackingBean {

    protected List<StudentAlt> studentsAltFilteredList;
    protected Long studentId;
    protected Long studentToUpdateId;
    protected Long studentToDeleteId;
    protected StudentAltModel studentAltModel;

    protected boolean isStudentAltModelEmpty(StudentAltModel studentAltModel) {
        return HelperClass.isStringNullOrEmpty(studentAltModel.getLastName()) &&
                HelperClass.isStringNullOrEmpty(studentAltModel.getFirstName()) &&
                studentAltModel.getDateOfBirth() == null &&
                studentAltModel.getAbsences() == null &&
                HelperClass.isStringNullOrEmpty(studentAltModel.getDepartmentId()) &&
                HelperClass.isStringNullOrEmpty(studentAltModel.getStatus().getValue());
    }

    public List<StudentAlt> getStudentsAltFilteredList() {
        return studentsAltFilteredList;
    }

    public void setStudentsAltFilteredList(List<StudentAlt> studentsAltFilteredList) {
        this.studentsAltFilteredList = studentsAltFilteredList;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentToUpdateId() {
        return studentToUpdateId;
    }

    public void setStudentToUpdateId(Long studentToUpdateId) {
        this.studentToUpdateId = studentToUpdateId;
    }

    public Long getStudentToDeleteId() {
        return studentToDeleteId;
    }

    public void setStudentToDeleteId(Long studentToDeleteId) {
        this.studentToDeleteId = studentToDeleteId;
    }

    public StudentAltModel getStudentAltModel() {
        return studentAltModel;
    }

    public void setStudentAltModel(StudentAltModel studentAltModel) {
        this.studentAltModel = studentAltModel;
    }
}
