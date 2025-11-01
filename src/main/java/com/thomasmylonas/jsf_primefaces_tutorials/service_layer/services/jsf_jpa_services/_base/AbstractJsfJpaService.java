package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.jsf_jpa_services._base;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services._base.AbstractService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class AbstractJsfJpaService extends AbstractService {

    protected List<Student> studentsFilteredList;

    // The "studentId" ID's collected from the user input
    protected Long studentId;
    protected Long updateFormStudentId;
    protected Long deleteFormStudentId;

    // The "student" info's collected from the user input
    protected Student saveFormStudent;
    protected Student updateFormStudent;

    public abstract void displayStudentById();

    public abstract List<Student> fetchAllStudents();

    public abstract void saveNewStudent(Student student);

    public abstract void updateStudent(Student student, Long id);

    public abstract void deleteStudent();

    protected boolean isStudentEmpty(Student student) {
        return HelperClass.isStringNullOrEmpty(student.getLastName()) &&
                HelperClass.isStringNullOrEmpty(student.getFirstName()) &&
                student.getDateOfBirth() == null &&
                student.getAbsences() == null &&
                HelperClass.isStringNullOrEmpty(student.getDepartmentId()) &&
                HelperClass.isStringNullOrEmpty(student.getStatus().getValue());
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
}
