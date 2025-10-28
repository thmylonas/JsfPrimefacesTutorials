package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.Student;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.enums.Status;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.exceptions.ResourceNotFoundException;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services._base.AbstractStudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ManagedBean(name = "inMemoryStudentService")
public class InMemoryStudentService extends AbstractStudentService {

    private List<Student> inMemoryStudentsList;

    @PostConstruct
    private void init() {
        initInMemoryStudentsList();
    }

    @Override
    public Student getStudentById(Long id) throws ResourceNotFoundException {
        return filterInMemoryStudentsListById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return inMemoryStudentsList;
    }

    @Override
    public Student saveStudent(Student student) {

        if (student == null) {
            return null;
        }
        inMemoryStudentsList.add(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student, Long id) throws ResourceNotFoundException {

        if (id == null || student == null) {
            return null;
        }
        Student studentToBeUpdated = getStudentById(id); // This might throw a "ResourceNotFoundException"
        updateStudentWithGivenObject(studentToBeUpdated, student);
        return studentToBeUpdated;
    }

    @Override
    public void deleteStudent(Long id) throws ResourceNotFoundException {

        Student studentToDelete = getStudentById(id); // This might throw a "ResourceNotFoundException"
        if (studentToDelete == null) {
            return;
        }
        inMemoryStudentsList.remove(studentToDelete);
    }

    private Student filterInMemoryStudentsListById(Long id) {

        // Filter the "inMemoryStudentsList" by ID
        return id == null ? null :
                inMemoryStudentsList
                        .stream()
                        .filter(student -> student.getId().equals(id))
                        .findAny()
                        .orElseThrow(() -> new ResourceNotFoundException(Student.class.getSimpleName(), id));
    }

    private void initInMemoryStudentsList() {

        inMemoryStudentsList = new ArrayList<>();

        inMemoryStudentsList.add(Student.builder()
                .id(1L)
                .lastName("Mylonas")
                .firstName("Thomas")
                .dateOfBirth(HelperClass.getDate(1972, Calendar.SEPTEMBER, 24))
                .absences(1)
                .departmentId("Dept1")
                .status(Status.ADVANCED_STUDENT)
                .build());
        inMemoryStudentsList.add(Student.builder()
                .id(2L)
                .lastName("Lorem")
                .firstName("Ipsum")
                .dateOfBirth(HelperClass.getDate(1979, Calendar.APRIL, 30))
                .absences(5)
                .departmentId("Dept1")
                .status(Status.JUNIOR_STUDENT)
                .build());
        inMemoryStudentsList.add(Student.builder()
                .id(3L)
                .lastName("Chan")
                .firstName("Jacky")
                .dateOfBirth(HelperClass.getDate(1982, Calendar.MAY, 9))
                .absences(3)
                .departmentId("Dept2")
                .status(Status.JUNIOR_STUDENT)
                .build());
        inMemoryStudentsList.add(Student.builder()
                .id(4L)
                .lastName("Parker")
                .firstName("Peter")
                .dateOfBirth(HelperClass.getDate(1990, Calendar.OCTOBER, 15))
                .absences(7)
                .departmentId("Dept3")
                .status(Status.MEDIUM_STUDENT)
                .build());
        inMemoryStudentsList.add(Student.builder()
                .id(5L)
                .lastName("Murdock")
                .firstName("Matt")
                .dateOfBirth(HelperClass.getDate(2000, Calendar.FEBRUARY, 2))
                .absences(2)
                .departmentId("Dept4")
                .status(Status.ADVANCED_STUDENT)
                .build());
    }
}
