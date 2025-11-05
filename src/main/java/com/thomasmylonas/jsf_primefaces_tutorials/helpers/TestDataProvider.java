package com.thomasmylonas.jsf_primefaces_tutorials.helpers;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.enums.Status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestDataProvider {

    private static final List<Student> STUDENTS = List.of(
            Student.builder()
                    .lastName("Mylonas")
                    .firstName("Thomas")
                    .dateOfBirth(HelperClass.buildDate(1972, Calendar.SEPTEMBER, 24))
                    .absences(1)
                    .departmentId("Dept1")
                    .status(Status.ADVANCED_STUDENT)
                    .build(),
            Student.builder()
                    .lastName("Lorem")
                    .firstName("Ipsum")
                    .dateOfBirth(HelperClass.buildDate(1979, Calendar.APRIL, 30))
                    .absences(5)
                    .departmentId("Dept1")
                    .status(Status.JUNIOR_STUDENT)
                    .build(),
            Student.builder()
                    .lastName("Chan")
                    .firstName("Jacky")
                    .dateOfBirth(HelperClass.buildDate(1982, Calendar.MAY, 9))
                    .absences(3)
                    .departmentId("Dept2")
                    .status(Status.JUNIOR_STUDENT)
                    .build(),
            Student.builder()
                    .lastName("Parker")
                    .firstName("Peter")
                    .dateOfBirth(HelperClass.buildDate(1990, Calendar.OCTOBER, 15))
                    .absences(7)
                    .departmentId("Dept3")
                    .status(Status.MEDIUM_STUDENT)
                    .build(),
            Student.builder()
                    .lastName("Murdock")
                    .firstName("Matt")
                    .dateOfBirth(HelperClass.buildDate(2000, Calendar.FEBRUARY, 2))
                    .absences(2)
                    .departmentId("Dept4")
                    .status(Status.ADVANCED_STUDENT)
                    .build()
    );

    public static List<Student> generateDBStudents() {
        return STUDENTS.stream()
                .map(student -> {
                    student.setId(null);
                    student.setLastName("DB_" + student.getLastName());
                    student.setFirstName("DB_" + student.getFirstName());
                    return student;
                }).toList();
    }

    public static List<Student> generateInMemoryStudents() {

        List<Student> students = new ArrayList<>(STUDENTS);
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setId((long) (i + 1));
        }
        return students;
    }
}
