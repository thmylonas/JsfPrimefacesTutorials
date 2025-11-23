package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.RequestedResourceNotFoundException;

import java.util.List;

public interface StudentService {

    Student findStudentById(Long id) throws RequestedResourceNotFoundException;

    List<Student> findAllStudents();

    void saveStudent(Student student);

    void updateStudent(Student student, Long id) throws RequestedResourceNotFoundException;

    void deleteStudent(Long id);
}
