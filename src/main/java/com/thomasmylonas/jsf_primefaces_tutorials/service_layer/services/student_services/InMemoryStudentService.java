package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.repositories.StudentDao;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.TestDataProvider;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
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
    public Student findStudentById(Long id) {

        if (id == null || id < 0) {
            throw new IllegalArgumentException("The id is not valid!");
        }
        return filterInMemoryStudentsListById(id); // ResourceNotFoundException
    }

    @Override
    public List<Student> findAllStudents() {
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
        Student studentToBeUpdated = findStudentById(id); // IllegalArgumentException, ResourceNotFoundException
        updateStudentWithGivenObject(studentToBeUpdated, student);
    }

    @Override
    public void deleteStudent(Long id) throws ResourceNotFoundException {
        Student studentToDelete = findStudentById(id); // IllegalArgumentException, ResourceNotFoundException
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
        inMemoryStudentsList = new ArrayList<>(TestDataProvider.generateInMemoryStudents());
    }
}
