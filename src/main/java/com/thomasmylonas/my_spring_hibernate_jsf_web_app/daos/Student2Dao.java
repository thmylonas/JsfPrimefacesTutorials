package com.thomasmylonas.my_spring_hibernate_jsf_web_app.daos;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.models.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component  // (value = "petDao") // With this, 2 beans are created
public class Student2Dao implements GenericJpaDao<Student, Integer> {

    private static final Logger LOGGER = LogManager.getLogger(StudentDao.class.getName());

    // @PersistenceContext
    private EntityManager em;
    private Transaction tx;

    public Student2Dao(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        EntityManagerFactory emf = entityManagerFactoryBean.getObject();
        this.em = emf.createEntityManager();
        this.tx = (Transaction) em.getTransaction();
    }

    @Override
    public Student findById(Integer id) {

        Student petResult = null;
        try {
            petResult = em.find(Student.class, id);
        } catch (IllegalArgumentException e) {
            tx.rollback();
            LOGGER.error(e.getMessage());
        }
        return petResult;
    }

    @Override
    public List<Student> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> pet = cq.from(Student.class);
        CriteriaQuery<Student> all = cq.select(pet);
        TypedQuery<Student> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public <S extends Student> S save(S pet) {

        S petPersisted = null;
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
//            sPersisted = em.merge(s);
            em.persist(pet);
            em.flush();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            LOGGER.error(e.getMessage());
        }
        return pet;
    }

    @Override
    public <S extends Student> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Student> S update(S pet) {

        Student updatedPet = null;
        Integer id = pet.getId();
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            Student petToUpdate = em.find(Student.class, id);
            if (petToUpdate == null) {
                throw new IllegalArgumentException();
            }
            updatedPet = em.merge(pet);
            em.flush();
            tx.commit();
        } catch (IllegalArgumentException e) {
            tx.rollback();
            LOGGER.error(e.getMessage());
        }
        return (S) updatedPet;
    }

    @Override
    public <S extends Student> void update(S pet, Integer id) {

        /*
        This method is another way to update
         */
        Integer id1 = pet.getId(); // id;
        Student petToBeUpdated = em.find(Student.class, id1);
        try {
            if (!tx.isActive()) {
                tx.begin();
            }
//            pet.setEverything(petToBeUpdated);
            em.flush();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {

        try {
            if (!tx.isActive()) {
                tx.begin();
            }
            Student petToDelete = em.find(Student.class, id);
            if (petToDelete == null) {
//                throw new ResourceNotFoundException(id, "The pet with id: %d, is not found");
            }
            em.remove(petToDelete);
            tx.commit();
        } catch (IllegalArgumentException e) {
            tx.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void delete(Student pet) {
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public void deleteAllGiven(Iterable<? extends Student> iterable) {
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {
    }
}
