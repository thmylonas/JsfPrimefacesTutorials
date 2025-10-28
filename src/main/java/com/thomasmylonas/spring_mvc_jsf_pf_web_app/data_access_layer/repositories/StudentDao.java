package com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.repositories;

import com.thomasmylonas.spring_mvc_jsf_pf_web_app.data_access_layer.entities.Student;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.helpers.HelperClass;
import com.thomasmylonas.spring_mvc_jsf_pf_web_app.service_layer.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class StudentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDao.class.getSimpleName());

    private final EntityManager em;

    public Student findById(Long id) {

        if (id == null || id < 0) {
            return null;
        }
        Student entityResult = em.find(Student.class, id);
        if (entityResult == null) {
            throw new ResourceNotFoundException(Student.class.getSimpleName(), id);
        }
        return entityResult;
    }

    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    public Student save(Student student) {

        try {
            em.getTransaction().begin();

            em.persist(student); // After "EntityManager::persist" the "entity" contains the "ID" with which is persisted

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.error("Because of an 'Exception': '{}', the transaction is rolled back!", e.getMessage());
        }
        return student;
    }

    public List<Student> saveAll(List<Student> entities) {

        List<Student> savedEntities = new ArrayList<>();
        try {
            em.getTransaction().begin();

            entities.forEach(r -> {
                em.persist(r);
                savedEntities.add(r);
            });

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.error("Because of an 'Exception': '{}', the transaction is rolled back!", e.getMessage());
        }
        return savedEntities;
    }

    public void update(Student student, Long id) {

        if (id == null || id < 0 || student == null) {
            return;
        }
        try {
            em.getTransaction().begin();

            Student studentToUpdate = findById(id);
            if (studentToUpdate == null) {
                throw new ResourceNotFoundException(Student.class.getSimpleName(), id);
            }
            if (!HelperClass.isStringNullOrEmpty(student.getLastName())) {
                studentToUpdate.setLastName(student.getLastName());
            }
            if (!HelperClass.isStringNullOrEmpty(student.getFirstName())) {
                studentToUpdate.setFirstName(student.getFirstName());
            }
            if (student.getDateOfBirth() != null) {
                studentToUpdate.setDateOfBirth(student.getDateOfBirth());
            }
            if (student.getAbsences() != null) {
                studentToUpdate.setAbsences(student.getAbsences());
            }
            if (!HelperClass.isStringNullOrEmpty(student.getDepartmentId())) {
                studentToUpdate.setDepartmentId(student.getDepartmentId());
            }
            if (student.getStatus() != null) {
                studentToUpdate.setStatus(student.getStatus());
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.error("Because of an 'Exception': '{}', the transaction is rolled back!", e.getMessage());
        }
    }

    public void deleteById(Long id) {

        if (id == null || id < 0) {
            return;
        }
        try {
            em.getTransaction().begin();

            Student entityToDelete = findById(id);
            if (entityToDelete == null) {
                throw new ResourceNotFoundException(Student.class.getSimpleName(), id);
            }
            em.remove(entityToDelete);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOGGER.error("Because of an 'Exception': '{}', the transaction is rolled back!", e.getMessage());
        }
    }
}
