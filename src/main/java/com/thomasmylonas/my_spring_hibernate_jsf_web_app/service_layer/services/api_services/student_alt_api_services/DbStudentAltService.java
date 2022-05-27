package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.student_alt_api_services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.repositories.StudentAltRepository;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions.ResourceNotFoundException;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.student_alt_api_services._base.AbstractStudentAltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service(value = "dbStudentAltService")
public class DbStudentAltService extends AbstractStudentAltService {

    private final StudentAltRepository studentAltRepository;

    @Autowired
    public DbStudentAltService(StudentAltRepository studentAltRepository) {
        this.studentAltRepository = studentAltRepository;
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public StudentAlt getStudentAltById(Long id) throws ResourceNotFoundException {

        if (id == null) {
            return null;
        }
        StudentAlt studentAlt = studentAltRepository.findById(id);
        if (studentAlt == null) {
            throw new ResourceNotFoundException(StudentAlt.class.getSimpleName(), id);
        }
        return studentAlt;
    }

    @Override
    public List<StudentAlt> getAllStudentsAlt() {
        return studentAltRepository.findAll();
    }

    @Override
    public StudentAlt saveStudentAlt(StudentAlt studentAlt) {

        if (studentAlt == null) {
            return null;
        }
        return studentAltRepository.save(studentAlt);
    }

    @Override
    public StudentAlt updateStudentAlt(StudentAlt studentAlt, Long id) throws ResourceNotFoundException {

        if (id == null || studentAlt == null) {
            return null;
        }
        StudentAlt studentAltToUpdate = studentAltRepository.findById(id);
        if (studentAltToUpdate == null) {
            throw new ResourceNotFoundException(StudentAlt.class.getSimpleName(), id);
        }
        updateStudentAltWithGivenObject(studentAltToUpdate, studentAlt);
        return studentAltRepository.save(studentAltToUpdate);
    }

    @Override
    public void deleteStudentAlt(Long id) throws ResourceNotFoundException {

        if (id == null) {
            return;
        }
        studentAltRepository.deleteById(id);
    }
}
