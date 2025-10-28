package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.Student;
//import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.enums.Status;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.repositories.StudentRepository;
//import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.exceptions.ResourceNotFoundException;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services._base.AbstractStudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
//import java.util.Calendar;
import java.util.List;

@ManagedBean(name = "dbStudentService")
public class DbStudentService extends AbstractStudentService {

    @ManagedProperty(value = "#{studentRepository}")
    private StudentRepository studentRepository;

    @PostConstruct
    private void init() {
        initStudentsList();
    }

    @Override
    public Student getStudentById(Long id) throws ResourceNotFoundException {

        if (id == null) {
            return null;
        }
//        return studentRepository.findById(id).
//                orElseThrow(() -> new ResourceNotFoundException(Student.class.getSimpleName(), id));
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
        return null;
    }

    @Override
    public Student saveStudent(Student student) {

        if (student == null) {
            return null;
        }
//        return studentRepository.save(student);
        return null;
    }

    @Override
    public Student updateStudent(Student student, Long id) throws ResourceNotFoundException {

        if (id == null || student == null) {
            return null;
        }
//        Student studentToBeUpdated = studentRepository.findById(id).
//                orElseThrow(() -> new ResourceNotFoundException(Student.class.getSimpleName(), id));
//        updateStudentWithGivenObject(studentToBeUpdated, student);
//        return studentRepository.save(studentToBeUpdated);
        return null;
    }

    @Override
    public void deleteStudent(Long id) throws ResourceNotFoundException {

        if (id == null) {
            return;
        }
//        studentRepository.deleteById(id);
    }

    private void initStudentsList() {

//        studentRepository.save(new Student.Builder()
//                .lastName("Mylonas")
//                .firstName("Thomas")
//                .dateOfBirth(HelperClass.getDate(1972, Calendar.SEPTEMBER, 24))
//                .absences(1)
//                .departmentId("Dept1")
//                .status(Status.ADVANCED_STUDENT)
//                .build());
//        studentRepository.save(new Student.Builder()
//                .lastName("Lorem")
//                .firstName("Ipsum")
//                .dateOfBirth(HelperClass.getDate(1979, Calendar.APRIL, 30))
//                .absences(5)
//                .departmentId("Dept1")
//                .status(Status.JUNIOR_STUDENT)
//                .build());
//        studentRepository.save(new Student.Builder()
//                .lastName("Chan")
//                .firstName("Jacky")
//                .dateOfBirth(HelperClass.getDate(1982, Calendar.MAY, 9))
//                .absences(3)
//                .departmentId("Dept2")
//                .status(Status.JUNIOR_STUDENT)
//                .build());
//        studentRepository.save(new Student.Builder()
//                .lastName("Parker")
//                .firstName("Peter")
//                .dateOfBirth(HelperClass.getDate(1990, Calendar.OCTOBER, 15))
//                .absences(7)
//                .departmentId("Dept3")
//                .status(Status.MEDIUM_STUDENT)
//                .build());
//        studentRepository.save(new Student.Builder()
//                .lastName("Murdock")
//                .firstName("Matt")
//                .dateOfBirth(HelperClass.getDate(2000, Calendar.FEBRUARY, 2))
//                .absences(2)
//                .departmentId("Dept4")
//                .status(Status.ADVANCED_STUDENT)
//                .build());
    }
}
