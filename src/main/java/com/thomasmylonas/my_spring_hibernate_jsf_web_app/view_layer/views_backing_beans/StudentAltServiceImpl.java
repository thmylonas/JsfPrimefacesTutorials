package com.thomasmylonas.my_spring_hibernate_jsf_web_app.view_layer.views_backing_beans;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.repositories.StudentAltRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "studentAltService")
public class StudentAltServiceImpl implements StudentAltService {

    @Autowired
    private StudentAltRepository studentAltRepository;

    @Override
    public StudentAlt getStudentAltById(Long id) {
        return studentAltRepository.findById(id);
    }

    // Work to be done
}
