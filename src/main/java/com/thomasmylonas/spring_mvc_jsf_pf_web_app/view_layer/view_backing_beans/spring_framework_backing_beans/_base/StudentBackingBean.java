package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.Student;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans.DbStudentBackingBean;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans.InMemoryStudentBackingBean;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "studentBackingBean")
@Getter
@Setter
public class StudentBackingBean extends AbstractBackingBean {

    private String dataSource;
    private boolean displayApiForms;

    protected List<Student> studentsFilteredList;

    // The "studentId" ID's collected from the user input
    protected Long studentId;
    protected Long updateFormStudentId;
    protected Long deleteFormStudentId;

    // The "student" info's collected from the user input
    protected Student saveFormStudent;
    protected Student updateFormStudent;

    private StudentBackingBean generalStudentBackingBean;

    @ManagedProperty(value = "#{inMemoryStudentBackingBean}")
    private InMemoryStudentBackingBean inMemoryStudentBackingBean;

    @ManagedProperty(value = "#{dbStudentBackingBean}")
    private DbStudentBackingBean dbStudentBackingBean;

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
            generalStudentBackingBean = inMemoryStudentBackingBean;
        } else if (dataSource.equalsIgnoreCase("DatabaseDS")) {
            displayApiForms = true;
            generalStudentBackingBean = dbStudentBackingBean;
        } else {
            displayApiForms = false;
        }
    }

    public String displayApiForms() {

        resetFetchByIdForm();
        resetSaveForm();
        resetUpdateForm();
        resetDeleteForm();
        return displayApiForms ? "display_api_forms" : "not_display_api_forms";
    }

    protected boolean isStudentEmpty(Student student) {
        return HelperClass.isStringNullOrEmpty(student.getLastName()) &&
                HelperClass.isStringNullOrEmpty(student.getFirstName()) &&
                student.getDateOfBirth() == null &&
                student.getAbsences() == null &&
                HelperClass.isStringNullOrEmpty(student.getDepartmentId()) &&
                HelperClass.isStringNullOrEmpty(student.getStatus().getValue());
    }

    protected void resetStudent(Student student) {

        if (student != null) {
            student.setLastName(null);
            student.setFirstName(null);
            student.setDateOfBirth(null);
            student.setAbsences(null);
            student.setDepartmentId(null);
            student.setStatus(null);
        }
    }

    public void resetFetchByIdForm() {
        studentsFilteredList = new ArrayList<>();
        studentId = null;
    }

    public void resetSaveForm() {
        resetStudent(saveFormStudent);
    }

    public void resetUpdateForm() {
        updateFormStudentId = null;
        resetStudent(updateFormStudent);
    }

    public void resetDeleteForm() {
        deleteFormStudentId = null;
    }
}
