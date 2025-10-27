package com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans._base;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans._base.AbstractBackingBean;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans.DbStudentAltBackingBean;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.view_layer.view_backing_beans.spring_framework_backing_beans.InMemoryStudentAltBackingBean;

import java.util.ArrayList;
import java.util.List;

//@Component(value = "studentAltBackingBean")
public class StudentAltBackingBean extends AbstractBackingBean {

    private String dataSource;
    private boolean displayApiForms;

    protected List<StudentAlt> studentsAltFilteredList;

    // The "studentAltId" ID's collected from the user input
    protected Long studentAltId;
    protected Long updateFormStudentAltId;
    protected Long deleteFormStudentAltId;

    // The "studentAlt" info's collected from the user input
    protected StudentAlt saveFormStudentAlt;
    protected StudentAlt updateFormStudentAlt;

    private StudentAltBackingBean generalStudentAltBackingBean;

//    @Autowired
    private InMemoryStudentAltBackingBean inMemoryStudentAltBackingBean;

//    @Autowired
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

        resetFetchByIdForm();
        resetSaveForm();
        resetUpdateForm();
        resetDeleteForm();
        return displayApiForms ? "display_api_forms" : "not_display_api_forms";
    }

    protected boolean isStudentAltEmpty(StudentAlt studentAlt) {
        return HelperClass.isStringNullOrEmpty(studentAlt.getLastName()) &&
                HelperClass.isStringNullOrEmpty(studentAlt.getFirstName()) &&
                studentAlt.getDateOfBirth() == null &&
                studentAlt.getAbsences() == null &&
                HelperClass.isStringNullOrEmpty(studentAlt.getDepartmentId()) &&
                HelperClass.isStringNullOrEmpty(studentAlt.getStatus().getValue());
    }

    protected void resetStudentAlt(StudentAlt studentAlt) {

        if (studentAlt != null) {
            studentAlt.setLastName(null);
            studentAlt.setFirstName(null);
            studentAlt.setDateOfBirth(null);
            studentAlt.setAbsences(null);
            studentAlt.setDepartmentId(null);
            studentAlt.setStatus(null);
        }
    }

    public void resetFetchByIdForm() {
        studentsAltFilteredList = new ArrayList<>();
        studentAltId = null;
    }

    public void resetSaveForm() {
        resetStudentAlt(saveFormStudentAlt);
    }

    public void resetUpdateForm() {
        updateFormStudentAltId = null;
        resetStudentAlt(updateFormStudentAlt);
    }

    public void resetDeleteForm() {
        deleteFormStudentAltId = null;
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

    public Long getUpdateFormStudentAltId() {
        return updateFormStudentAltId;
    }

    public void setUpdateFormStudentAltId(Long updateFormStudentAltId) {
        this.updateFormStudentAltId = updateFormStudentAltId;
    }

    public Long getDeleteFormStudentAltId() {
        return deleteFormStudentAltId;
    }

    public void setDeleteFormStudentAltId(Long deleteFormStudentAltId) {
        this.deleteFormStudentAltId = deleteFormStudentAltId;
    }

    public StudentAlt getSaveFormStudentAlt() {
        return saveFormStudentAlt;
    }

    public void setSaveFormStudentAlt(StudentAlt saveFormStudentAlt) {
        this.saveFormStudentAlt = saveFormStudentAlt;
    }

    public StudentAlt getUpdateFormStudentAlt() {
        return updateFormStudentAlt;
    }

    public void setUpdateFormStudentAlt(StudentAlt updateFormStudentAlt) {
        this.updateFormStudentAlt = updateFormStudentAlt;
    }

    public StudentAltBackingBean getGeneralStudentAltBackingBean() {
        return generalStudentAltBackingBean;
    }

    public void setGeneralStudentAltBackingBean(StudentAltBackingBean generalStudentAltBackingBean) {
        this.generalStudentAltBackingBean = generalStudentAltBackingBean;
    }
}
