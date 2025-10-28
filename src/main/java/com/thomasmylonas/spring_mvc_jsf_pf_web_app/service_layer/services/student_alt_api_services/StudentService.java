package com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.student_alt_api_services;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.Student;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.exceptions.ResourceNotFoundException;

import java.util.List;

public interface StudentService {

    Student getStudentById(Long id) throws ResourceNotFoundException;

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student updateStudent(Student student, Long id) throws ResourceNotFoundException;

    void deleteStudent(Long id) throws ResourceNotFoundException;
}
