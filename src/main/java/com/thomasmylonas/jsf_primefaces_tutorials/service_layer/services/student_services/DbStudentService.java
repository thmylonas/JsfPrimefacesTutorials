package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.enums.Status;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.repositories.StudentDao;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services._base.AbstractService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.Calendar;
import java.util.List;

@ManagedBean(name = "dbStudentService")
@SessionScoped
@Getter
@Setter
public class DbStudentService extends AbstractService implements StudentService {

    @ManagedProperty(value = "#{studentDao}")
    private StudentDao studentDao;

    @PostConstruct
    private void init() {
        initStudentsList();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.findById(id); // IllegalArgumentException, ResourceNotFoundException
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student saveStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("The student is not valid (is null)!");
        }
        Student studentToSave = Student.builder()
                .id(student.getId())
                .lastName(student.getLastName())
                .firstName(student.getFirstName())
                .dateOfBirth(student.getDateOfBirth())
                .absences(student.getAbsences())
                .departmentId(student.getDepartmentId())
                .status(student.getStatus())
                .build();
        return studentDao.save(studentToSave);  // IllegalArgumentException
    }

    @Override
    public void updateStudent(Student student, Long id) {
        studentDao.update(student, id); // IllegalArgumentException, ResourceNotFoundException
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteById(id); // IllegalArgumentException, ResourceNotFoundException
    }

    private void initStudentsList() {

        studentDao.save(Student.builder()
                .lastName("DB_Mylonas")
                .firstName("DB_Thomas")
                .dateOfBirth(HelperClass.buildDate(1972, Calendar.SEPTEMBER, 24))
                .absences(1)
                .departmentId("Dept1")
                .status(Status.ADVANCED_STUDENT)
                .build());
        studentDao.save(Student.builder()
                .lastName("DB_Lorem")
                .firstName("DB_Ipsum")
                .dateOfBirth(HelperClass.buildDate(1979, Calendar.APRIL, 30))
                .absences(5)
                .departmentId("Dept1")
                .status(Status.JUNIOR_STUDENT)
                .build());
        studentDao.save(Student.builder()
                .lastName("DB_Chan")
                .firstName("DB_Jacky")
                .dateOfBirth(HelperClass.buildDate(1982, Calendar.MAY, 9))
                .absences(3)
                .departmentId("Dept2")
                .status(Status.JUNIOR_STUDENT)
                .build());
        studentDao.save(Student.builder()
                .lastName("DB_Parker")
                .firstName("DB_Peter")
                .dateOfBirth(HelperClass.buildDate(1990, Calendar.OCTOBER, 15))
                .absences(7)
                .departmentId("Dept3")
                .status(Status.MEDIUM_STUDENT)
                .build());
        studentDao.save(Student.builder()
                .lastName("DB_Murdock")
                .firstName("DB_Matt")
                .dateOfBirth(HelperClass.buildDate(2000, Calendar.FEBRUARY, 2))
                .absences(2)
                .departmentId("Dept4")
                .status(Status.ADVANCED_STUDENT)
                .build());
    }
}
