package com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.repositories;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "studentAltRepository")
public interface StudentAltRepository extends JpaRepository<StudentAlt, Long> {
}
