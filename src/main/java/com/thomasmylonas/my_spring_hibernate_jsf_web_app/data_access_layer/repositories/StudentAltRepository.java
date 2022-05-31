package com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.repositories;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Take a look at the manual transactions...
 * Use @Transactional
 */
@Repository //(value = "studentAltRepository") // With this, 2 beans are created
public class StudentAltRepository implements GenericJpaRepository<StudentAlt, Long> {

    private final Logger LOGGER = LogManager.getLogger(getClass().getName());

    private EntityManager EM;
    private Transaction TX;

    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;

    @PostConstruct
    private void init() {

        EntityManagerFactory emf = entityManagerFactoryBean.getObject();
        if (emf != null) {
            EM = emf.createEntityManager();
            TX = (Transaction) EM.getTransaction();
        }
    }

    @Override
    public StudentAlt findById(Long id) {

        StudentAlt studentAltResult = null;
        try {
            studentAltResult = EM.find(StudentAlt.class, id);
        } catch (IllegalArgumentException e) {
            TX.rollback();
            LOGGER.error(e.getMessage());
        }
        return studentAltResult;
    }

    @Override
    public List<StudentAlt> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public List<StudentAlt> findAll() {

        CriteriaBuilder cb = EM.getCriteriaBuilder();
        CriteriaQuery<StudentAlt> cq = cb.createQuery(StudentAlt.class);
        Root<StudentAlt> studentAlt = cq.from(StudentAlt.class);
        CriteriaQuery<StudentAlt> all = cq.select(studentAlt);
        TypedQuery<StudentAlt> allQuery = EM.createQuery(all);
        return allQuery.getResultList();
    }

    /**
     * The use of "EM.persist(studentAlt)", leads to the error:
     * "javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist"
     *
     * @param studentAlt The entity to persist (must not be {@literal null})
     * @param <S>        The generic type of the entity "StudentAlt"
     * @return The entity which have persisted
     */
    @Override
    //@Transactional
    public <S extends StudentAlt> S save(S studentAlt) {

        S studentAltPersisted = null;
        try {
            if (!TX.isActive()) {
                TX.begin();
            }
            studentAltPersisted = EM.merge(studentAlt);
            EM.flush();
            TX.commit();
        } catch (Exception e) {
            TX.rollback();
            LOGGER.error(e.getMessage());
        }
        return studentAltPersisted;
    }

    @Override
    public <S extends StudentAlt> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends StudentAlt> S update(S studentAlt) {

        StudentAlt updatedStudentAlt = null;
        Long id = studentAlt.getId();
        try {
            if (!TX.isActive()) {
                TX.begin();
            }
            StudentAlt studentAltToUpdate = EM.find(StudentAlt.class, id);
            if (studentAltToUpdate == null) {
                throw new IllegalArgumentException();
            }
            updatedStudentAlt = EM.merge(studentAlt);
            EM.flush();
            TX.commit();
        } catch (IllegalArgumentException e) {
            TX.rollback();
            LOGGER.error(e.getMessage());
        }
        return (S) updatedStudentAlt;
    }

    @Override
    public <S extends StudentAlt> void update(S studentAlt, Long id) {

        /*
        This method is another way to update
         */
        Long id1 = studentAlt.getId(); // id;
        StudentAlt studentAltToBeUpdated = EM.find(StudentAlt.class, id1);
        try {
            if (!TX.isActive()) {
                TX.begin();
            }
            //studentAlt.setEverything(studentAltToBeUpdated);
            EM.flush();
            TX.commit();
        } catch (Exception e) {
            TX.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {

        try {
            if (!TX.isActive()) {
                TX.begin();
            }
            StudentAlt studentToDelete = EM.find(StudentAlt.class, id);
            if (studentToDelete == null) {
//                throw new ResourceNotFoundException(id, "The studentAlt with id: %d, is not found");
            }
            EM.remove(studentToDelete);
            TX.commit();
        } catch (IllegalArgumentException e) {
            TX.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void delete(StudentAlt studentAlt) {
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public void deleteAllGiven(Iterable<? extends StudentAlt> iterable) {
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public void flush() {
    }
}
