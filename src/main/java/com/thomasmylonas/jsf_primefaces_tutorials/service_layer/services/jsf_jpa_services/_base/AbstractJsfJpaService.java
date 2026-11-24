package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services._base;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services._base.AbstractService;
import lombok.Getter;
import lombok.Setter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Getter
@Setter
public abstract class AbstractJsfJpaService extends AbstractService {

    protected List<Student> studentsFiltered;

    // The "studentId" ID's collected from the user input
    protected Long studentId;
    protected Long updateFormStudentId;
    protected Long deleteFormStudentId;

    // The "student" info's collected from the user input
    protected Student saveFormStudent;
    protected Student updateFormStudent;

    public abstract void findStudentById();

    public abstract List<Student> findAllStudents();

    public abstract void saveNewStudent(Student student);

    public abstract void updateStudent(Student student, Long id);

    public abstract void deleteStudent();

    protected boolean isStudentEmpty(Student student) {
        return HelperClass.isStringNullOrEmpty(student.getLastName()) &&
                HelperClass.isStringNullOrEmpty(student.getFirstName()) &&
                student.getDateOfBirth() == null &&
                student.getAbsences() == null &&
                HelperClass.isStringNullOrEmpty(student.getDepartmentId()) &&
                HelperClass.isStringNullOrEmpty(student.getStatus() != null ? student.getStatus().getValue() : "");
    }

    public void resetStudent(Student student) {

        if (student != null) {
            student.setLastName(null);
            student.setFirstName(null);
            student.setDateOfBirth(null);
            student.setAbsences(null);
            student.setDepartmentId(null);
            student.setStatus(null);
        }
    }

    protected String noStudentWithIdMessage(String datasource, String id, String action) {
        return String.format("Database %s: There is no student with id %s, to %s!", datasource, id, action);
    }

    protected String inputDataNotValidMessage(String exceptionMessage) {
        return String.format("Database Datasource: Input data are not valid! - %s", exceptionMessage);
    }

    protected String failureMessage(String exceptionMessage) {
        return String.format("Database Datasource: Failure while processing this operation! - %s", exceptionMessage);
    }

    protected void displayFacesMessage(FacesMessage.Severity severity, String title, String message) {
        FacesMessage facesMessage = new FacesMessage(severity, title, message);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
