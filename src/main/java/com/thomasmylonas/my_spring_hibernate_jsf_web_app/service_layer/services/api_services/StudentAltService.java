package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions.ResourceNotFoundException;

import java.util.List;

public interface StudentAltService {

    StudentAlt getStudentAltById(Long id) throws ResourceNotFoundException;

    List<StudentAlt> getAllStudentsAlt();

    StudentAlt saveStudentAlt(StudentAlt studentAlt);

    StudentAlt updateStudentAlt(StudentAlt studentAlt, Long id) throws ResourceNotFoundException;

    void deleteStudentAlt(Long id) throws ResourceNotFoundException;
}
