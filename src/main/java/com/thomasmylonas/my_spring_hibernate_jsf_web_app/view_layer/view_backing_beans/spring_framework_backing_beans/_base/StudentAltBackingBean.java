package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.spring_framework_models.StudentAltModel;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans.DbStudentAltBackingBean;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans.InMemoryStudentAltBackingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "studentAltBackingBean")
public class StudentAltBackingBean extends AbstractBackingBean {

    private String dataSource;
    private boolean displayApiForms;

    protected List<StudentAlt> studentsAltFilteredList; // This might be put in the "InMemoryStudentAltBackingBean" only. Maybe the Getters/Setters not be useful
    protected Long studentAltId;
    protected Long studentAltToUpdateId;
    protected Long studentAltToDeleteId;
    protected StudentAltModel studentAltToSaveModel;
    protected StudentAltModel studentAltToUpdateModel;

    private StudentAltBackingBean generalStudentAltBackingBean;

    @Autowired
    private InMemoryStudentAltBackingBean inMemoryStudentAltBackingBean;

    @Autowired
    private DbStudentAltBackingBean dbStudentAltBackingBean;

    public String displayDataSource() {

        if (dataSource == null) {
            return "";
        } else {
            if (dataSource.equalsIgnoreCase("InMemoryDS")) {
                return " (Using an " + highlightingSpan("'In-Memory DataSource'", COLOR_BLUE, "bold") + ")";
            } else if (dataSource.equalsIgnoreCase("DatabaseDS")) {
                return " (Using an " + highlightingSpan("'Database DataSource'", COLOR_BLUE, "bold") + ")";
            } else {
                return "";
            }
        }
    }

    public void selectDatasource() {

        if (dataSource.equalsIgnoreCase("InMemoryDS")) {
            displayApiForms = true;
            generalStudentAltBackingBean = inMemoryStudentAltBackingBean;
        } else if (dataSource.equalsIgnoreCase("DatabaseDS")) {
            displayApiForms = true;
            generalStudentAltBackingBean = dbStudentAltBackingBean;
        } else {
            displayApiForms = false;
        }
    }

    public String displayApiForms() {
        return displayApiForms ? "display_api_forms" : "not_display_api_forms";
    }

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

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
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

    public StudentAltBackingBean getGeneralStudentAltBackingBean() {
        return generalStudentAltBackingBean;
    }

    public void setGeneralStudentAltBackingBean(StudentAltBackingBean generalStudentAltBackingBean) {
        this.generalStudentAltBackingBean = generalStudentAltBackingBean;
    }
}
