package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.enums.Status;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.helpers.HelperClass;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service(value = "inMemoryStudentAltService")
public class InMemoryStudentAltService implements StudentAltService {

    private List<StudentAlt> inMemoryStudentsAltList;

    @PostConstruct
    public void init() {
        initInMemoryStudentsAltList();
    }

    @Override
    public StudentAlt getStudentAltById(Long id) {
        if (id == null) {
            return null;
        }
        return filterInMemoryStudentsAltListById(id); // This might throw a "ResourceNotFoundException"
    }

    public List<StudentAlt> getStudentAltByIdWrappedInList(Long id) {
        return Stream.of(getStudentAltById(id)).collect(Collectors.toList()); // This might throw a "ResourceNotFoundException"
    }

    @Override
    public List<StudentAlt> getAllStudentsAlt() {
        return inMemoryStudentsAltList;
    }

    @Override
    public StudentAlt saveStudentAlt(StudentAlt studentAlt) {
        inMemoryStudentsAltList.add(studentAlt);
        return studentAlt;
    }

    @Override
    public StudentAlt updateStudentAlt(StudentAlt studentAlt, Long id) {

        StudentAlt studentAltToUpdate = inMemoryStudentsAltList.get(id.intValue());
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
        return studentAltToUpdate;
    }

    @Override
    public void deleteStudentAlt(Long id) throws ResourceNotFoundException {
        inMemoryStudentsAltList.remove(id.intValue());
    }

    private StudentAlt filterInMemoryStudentsAltListById(Long id) {

        // Filter the "inMemoryStudentsAltList" by ID
        return inMemoryStudentsAltList
                .stream()
                .filter(studentAlt -> studentAlt.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException(StudentAlt.class.getSimpleName(), id));
    }

    private void initInMemoryStudentsAltList() {

        inMemoryStudentsAltList = new ArrayList<>();

        inMemoryStudentsAltList.add(new StudentAlt.Builder()
                .id(1L)
                .lastName("Mylonas")
                .firstName("Thomas")
                .dateOfBirth(HelperClass.getDate(1972, Calendar.SEPTEMBER, 24))
                .absences(1)
                .departmentId("Dept1")
                .status(Status.ADVANCED_STUDENT)
                .build());
        inMemoryStudentsAltList.add(new StudentAlt.Builder()
                .id(2L)
                .lastName("Lorem")
                .firstName("Ipsum")
                .dateOfBirth(HelperClass.getDate(1979, Calendar.APRIL, 30))
                .absences(5)
                .departmentId("Dept1")
                .status(Status.JUNIOR_STUDENT)
                .build());
        inMemoryStudentsAltList.add(new StudentAlt.Builder()
                .id(3L)
                .lastName("Chan")
                .firstName("Jacky")
                .dateOfBirth(HelperClass.getDate(1982, Calendar.MAY, 9))
                .absences(3)
                .departmentId("Dept2")
                .status(Status.JUNIOR_STUDENT)
                .build());
        inMemoryStudentsAltList.add(new StudentAlt.Builder()
                .id(4L)
                .lastName("Parker")
                .firstName("Peter")
                .dateOfBirth(HelperClass.getDate(1990, Calendar.OCTOBER, 15))
                .absences(7)
                .departmentId("Dept3")
                .status(Status.MEDIUM_STUDENT)
                .build());
        inMemoryStudentsAltList.add(new StudentAlt.Builder()
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
