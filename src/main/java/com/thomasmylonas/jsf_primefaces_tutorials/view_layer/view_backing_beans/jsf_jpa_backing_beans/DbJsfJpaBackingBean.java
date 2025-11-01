package com.thomasmylonas.jsf_primefaces_tutorials.view_layer.view_backing_beans.jsf_jpa_backing_beans;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.HelperClass;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.ResourceNotFoundException;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services.StudentService;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "dbJsfJpaBackingBean")
public class DbJsfJpaBackingBean extends JsfJpaBackingBean {

    private StudentService dbStudentService;
//    private final StudentService dbStudentService;

    public DbJsfJpaBackingBean() {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentsPU_H2");
//        EntityManager em = null;
//
//        try {
//            em = emf.createEntityManager(); // IllegalStateException
//            StudentDao studentDao = new StudentDao(em);
//            this.dbStudentService = new DbStudentService(studentDao);
//        } catch (Exception e) {
//            throw new RuntimeException("Error creating EntityManager", e);
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//            // In the In-Memory H2-Database run cases, if "emf.close()", the tables/data in the H2-Database are deleted
//            LOGGER.warn("In the In-Memory H2-Database run cases, if 'emf.close()', the tables/data in the H2-Database are deleted");
//            //emf.close();
//        }

        studentsFilteredList = new ArrayList<>();
        saveFormStudent = new Student();
        updateFormStudent = new Student();
    }

    public void displayStudentById() {

        if (studentId == null) {
            return;
        }
        // Reset the "studentsFilteredList"
        studentsFilteredList = new ArrayList<>();
        // Populate the "studentsFilteredList" with the only 1 entry (to use it in the "h:dataTable", "p:dataTable")
        try {
            studentsFilteredList.add(dbStudentService.getStudentById(studentId));
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public List<Student> fetchAllStudents() {

        List<Student> allStudentsList = dbStudentService.getAllStudents();
        if (HelperClass.isListNullOrEmpty(allStudentsList)) {
            // Display error message (somehow)
        }
        return allStudentsList;
    }

    public void saveNewStudent(Student student) {

        if (isStudentEmpty(student)) {
            return;
        }
        dbStudentService.saveStudent(student);
    }

    public void updateStudent(Student student, Long id) {

        if (id == null || isStudentEmpty(student)) {
            return;
        }
        try {
            dbStudentService.updateStudent(student, id);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }

    public void deleteStudent() {

        if (deleteFormStudentId == null) {
            return;
        }
        try {
            dbStudentService.deleteStudent(deleteFormStudentId);
        } catch (ResourceNotFoundException e) {
            // Display error message (somehow)
        }
    }
}
