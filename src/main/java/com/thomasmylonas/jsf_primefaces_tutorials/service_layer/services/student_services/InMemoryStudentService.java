package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.enums.Status;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.repositories.StudentDao;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ManagedBean(name = "inMemoryStudentService")
@SessionScoped
public class InMemoryStudentService extends StudentDao implements StudentService {

    private List<Student> inMemoryStudentsList;

    @PostConstruct
    private void init() {
        initInMemoryStudentsList();
    }

    @Override
    public Student getStudentById(Long id) {

        if (id == null || id < 0) {
            throw new IllegalArgumentException("The id is not valid!");
        }
        return filterInMemoryStudentsListById(id); // ResourceNotFoundException
    }

    @Override
    public List<Student> getAllStudents() {
        return inMemoryStudentsList;
    }

    @Override
    public Student saveStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("The student is not valid (is null)!");
        }
        /*Student studentToSave = Student.builder()
                .id(student.getId())
                .lastName(student.getLastName())
                .firstName(student.getFirstName())
                .dateOfBirth(student.getDateOfBirth())
                .absences(student.getAbsences())
                .departmentId(student.getDepartmentId())
                .status(student.getStatus())
                .build();*/
        inMemoryStudentsList.add(student);
        return student;
    }

    @Override
    public void updateStudent(Student student, Long id) {

        if (id == null || id < 0 || student == null) {
            throw new IllegalArgumentException("The arguments are not valid!");
        }
        Student studentToBeUpdated = getStudentById(id); // IllegalArgumentException, ResourceNotFoundException
        updateStudentWithGivenObject(studentToBeUpdated, student);
    }

    @Override
    public void deleteStudent(Long id) throws ResourceNotFoundException {
        Student studentToDelete = getStudentById(id); // IllegalArgumentException, ResourceNotFoundException
        inMemoryStudentsList.remove(studentToDelete);
    }

    private Student filterInMemoryStudentsListById(Long id) {
        return inMemoryStudentsList
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
                .dateOfBirth(HelperClass.buildDate(1972, Calendar.SEPTEMBER, 24))
                .absences(1)
                .departmentId("Dept1")
                .status(Status.ADVANCED_STUDENT)
                .build());
        inMemoryStudentsList.add(Student.builder()
                .id(2L)
                .lastName("Lorem")
                .firstName("Ipsum")
                .dateOfBirth(HelperClass.buildDate(1979, Calendar.APRIL, 30))
                .absences(5)
                .departmentId("Dept1")
                .status(Status.JUNIOR_STUDENT)
                .build());
        inMemoryStudentsList.add(Student.builder()
                .id(3L)
                .lastName("Chan")
                .firstName("Jacky")
                .dateOfBirth(HelperClass.buildDate(1982, Calendar.MAY, 9))
                .absences(3)
                .departmentId("Dept2")
                .status(Status.JUNIOR_STUDENT)
                .build());
        inMemoryStudentsList.add(Student.builder()
                .id(4L)
                .lastName("Parker")
                .firstName("Peter")
                .dateOfBirth(HelperClass.buildDate(1990, Calendar.OCTOBER, 15))
                .absences(7)
                .departmentId("Dept3")
                .status(Status.MEDIUM_STUDENT)
                .build());
        inMemoryStudentsList.add(Student.builder()
                .id(5L)
                .lastName("Murdock")
                .firstName("Matt")
                .dateOfBirth(HelperClass.buildDate(2000, Calendar.FEBRUARY, 2))
                .absences(2)
                .departmentId("Dept4")
                .status(Status.ADVANCED_STUDENT)
                .build());
    }
}
