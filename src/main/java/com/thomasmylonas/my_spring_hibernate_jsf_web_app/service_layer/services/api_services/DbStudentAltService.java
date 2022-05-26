package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.repositories.StudentAltRepository;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service(value = "dbStudentAltService")
public class DbStudentAltService implements StudentAltService {

    private final StudentAltRepository studentAltRepository;

    @Autowired
    public DbStudentAltService(StudentAltRepository studentAltRepository) {
        this.studentAltRepository = studentAltRepository;
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public StudentAlt getStudentAltById(Long id) {

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
        return studentAltRepository.save(studentAlt);
    }

    @Override
    public StudentAlt updateStudentAlt(StudentAlt studentAlt, Long id) {

        StudentAlt studentAltToUpdate = studentAltRepository.findById(id);
        if (studentAltToUpdate == null) {
            throw new ResourceNotFoundException(StudentAlt.class.getSimpleName(), id);
        }

        if (!HelperClass.isStringNullOrEmpty(studentAlt.getLastName())) {
            studentAltToUpdate.setLastName(studentAlt.getLastName());
        }
        if (!HelperClass.isStringNullOrEmpty(studentAlt.getFirstName())) {
            studentAltToUpdate.setFirstName(studentAlt.getFirstName());
        }
        if (studentAlt.getDateOfBirth() != null) {
            studentAltToUpdate.setDateOfBirth(studentAlt.getDateOfBirth());
        }
        if (studentAlt.getAbsences() != null) {
            studentAltToUpdate.setAbsences(studentAlt.getAbsences());
        }
        if (!HelperClass.isStringNullOrEmpty(studentAlt.getDepartmentId())) {
            studentAltToUpdate.setDepartmentId(studentAlt.getDepartmentId());
        }
        if (!HelperClass.isStringNullOrEmpty(studentAlt.getStatus().getValue())) {
            studentAltToUpdate.setStatus(studentAlt.getStatus());
        }
        return studentAltRepository.save(studentAltToUpdate);
    }

    @Override
    public void deleteStudentAlt(Long id) throws ResourceNotFoundException {
        studentAltRepository.deleteById(id);
    }
}
