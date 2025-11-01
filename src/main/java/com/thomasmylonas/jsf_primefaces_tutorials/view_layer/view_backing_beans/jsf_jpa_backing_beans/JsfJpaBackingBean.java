package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_jpa_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans._base.AbstractBackingBean;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "jsfJpaBackingBean")
@Getter
@Setter
public class JsfJpaBackingBean extends AbstractBackingBean {

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

    private JsfJpaBackingBean generalJsfJpaBackingBean;

//    @ManagedProperty(value = "#{inMemoryJsfJpaBackingBean}")
//    private InMemoryJsfJpaBackingBean inMemoryJsfJpaBackingBean;
//
//    @ManagedProperty(value = "#{dbJsfJpaBackingBean}")
//    private DbJsfJpaBackingBean dbJsfJpaBackingBean;

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
//            generalJsfJpaBackingBean = inMemoryJsfJpaBackingBean;
        } else if (dataSource.equalsIgnoreCase("DatabaseDS")) {
            displayApiForms = true;
//            generalJsfJpaBackingBean = dbJsfJpaBackingBean;
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
