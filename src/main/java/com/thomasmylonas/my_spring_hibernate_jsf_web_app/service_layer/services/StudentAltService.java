package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;

public interface StudentAltService {
    StudentAlt getStudentAltById(Long id);
}
