package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.enums.Status;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.repositories.StudentAltRepository;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "studentAltService")
public class StudentAltServiceImpl implements StudentAltService {

    private final StudentAltRepository studentAltRepository;

    private List<StudentAlt> studentsAltListHardcoded;
    private List<StudentAlt> studentsAltListHardcodedFiltered;

    private Long studentId;


    public List<StudentAlt> getStudentsAltListHardcoded() {
        return studentsAltListHardcoded;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Autowired
    public StudentAltServiceImpl(StudentAltRepository studentAltRepository) {
        this.studentAltRepository = studentAltRepository;
    }

    @PostConstruct
    public void init() {
        initStudentsAltListHardcoded();
        studentsAltListHardcodedFiltered = new ArrayList<>();
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

    @Override
    public List<StudentAlt> fetchAllStudentsAltHardcoded() {
        return studentsAltListHardcodedFiltered;
    }

    public void filterStudentsAltListHardcodedById(Long id) {

        // Reset the "studentsAltListHardcodedFiltered"
        studentsAltListHardcodedFiltered = new ArrayList<>();
        // Filter the "studentsAltListHardcoded" by ID
        studentsAltListHardcodedFiltered.addAll(
                studentsAltListHardcoded.stream().filter(studentAlt -> studentAlt.getId().equals(id)).collect(Collectors.toList()));
    }

    public void resetFormWhichGetsStudentAltById() {
        studentsAltListHardcodedFiltered = new ArrayList<>();
        studentId = null;
    }

    private void initStudentsAltListHardcoded() {

        studentsAltListHardcoded = new ArrayList<>();

        studentsAltListHardcoded.add(new StudentAlt.Builder()
                .id(1L)
                .lastName("Mylonas")
                .firstName("Thomas")
                .dateOfBirth(HelperClass.getDate(1972, Calendar.SEPTEMBER, 24))
                .absences(1)
                .departmentId("Dept1")
                .status(Status.ADVANCED_STUDENT)
                .build());
        studentsAltListHardcoded.add(new StudentAlt.Builder()
                .id(2L)
                .lastName("Lorem")
                .firstName("Ipsum")
                .dateOfBirth(HelperClass.getDate(1979, Calendar.APRIL, 30))
                .absences(5)
                .departmentId("Dept1")
                .status(Status.JUNIOR_STUDENT)
                .build());
        studentsAltListHardcoded.add(new StudentAlt.Builder()
                .id(3L)
                .lastName("Chan")
                .firstName("Jacky")
                .dateOfBirth(HelperClass.getDate(1982, Calendar.MAY, 9))
                .absences(3)
                .departmentId("Dept2")
                .status(Status.JUNIOR_STUDENT)
                .build());
        studentsAltListHardcoded.add(new StudentAlt.Builder()
                .id(4L)
                .lastName("Parker")
                .firstName("Peter")
                .dateOfBirth(HelperClass.getDate(1990, Calendar.OCTOBER, 15))
                .absences(7)
                .departmentId("Dept3")
                .status(Status.MEDIUM_STUDENT)
                .build());
        studentsAltListHardcoded.add(new StudentAlt.Builder()
                .id(5L)
                .lastName("Murdock")
                .firstName("Mat")
                .dateOfBirth(HelperClass.getDate(2000, Calendar.FEBRUARY, 2))
                .absences(2)
                .departmentId("Dept4")
                .status(Status.ADVANCED_STUDENT)
                .build());
    }
}
