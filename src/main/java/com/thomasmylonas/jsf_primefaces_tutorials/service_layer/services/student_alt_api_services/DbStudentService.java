package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_alt_api_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.enums.Status;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.repositories.StudentDao;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.ResourceNotFoundException;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_alt_api_services._base.AbstractStudentService;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.Calendar;
import java.util.List;

@ManagedBean(name = "dbStudentService")
@RequiredArgsConstructor
public class DbStudentService extends AbstractStudentService {

    private final StudentDao studentDao;

    @PostConstruct
    private void init() {
        initStudentsList();
    }

    @Override
    public Student getStudentById(Long id) throws ResourceNotFoundException {

        if (id == null) {
            return null;
        }
        return studentDao.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student saveStudent(Student student) {

        if (student == null) {
            return null;
        }
        return studentDao.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) throws ResourceNotFoundException {

        if (id == null || student == null) {
            return null;
        }
        Student studentToBeUpdated = studentDao.findById(id);
        updateStudentWithGivenObject(studentToBeUpdated, student);
        return studentDao.save(studentToBeUpdated);
    }

    @Override
    public void deleteStudent(Long id) throws ResourceNotFoundException {

        if (id == null) {
            return;
        }
        studentDao.deleteById(id);
    }

    private void initStudentsList() {

        studentDao.save(Student.builder()
                .lastName("Mylonas")
                .firstName("Thomas")
                .dateOfBirth(HelperClass.buildDate(1972, Calendar.SEPTEMBER, 24))
                .absences(1)
                .departmentId("Dept1")
                .status(Status.ADVANCED_STUDENT)
                .build());
        studentDao.save(Student.builder()
                .lastName("Lorem")
                .firstName("Ipsum")
                .dateOfBirth(HelperClass.buildDate(1979, Calendar.APRIL, 30))
                .absences(5)
                .departmentId("Dept1")
                .status(Status.JUNIOR_STUDENT)
                .build());
        studentDao.save(Student.builder()
                .lastName("Chan")
                .firstName("Jacky")
                .dateOfBirth(HelperClass.buildDate(1982, Calendar.MAY, 9))
                .absences(3)
                .departmentId("Dept2")
                .status(Status.JUNIOR_STUDENT)
                .build());
        studentDao.save(Student.builder()
                .lastName("Parker")
                .firstName("Peter")
                .dateOfBirth(HelperClass.buildDate(1990, Calendar.OCTOBER, 15))
                .absences(7)
                .departmentId("Dept3")
                .status(Status.MEDIUM_STUDENT)
                .build());
        studentDao.save(Student.builder()
                .lastName("Murdock")
                .firstName("Matt")
                .dateOfBirth(HelperClass.buildDate(2000, Calendar.FEBRUARY, 2))
                .absences(2)
                .departmentId("Dept4")
                .status(Status.ADVANCED_STUDENT)
                .build());
    }
}
