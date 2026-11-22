package com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.student_services;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.Student;
import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.repositories.StudentDao;
import com.thomasmylonas.jsf_primefaces_tutorials.helpers.TestDataProvider;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services._base.AbstractService;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.GeneralRollbackException;
import com.thomasmylonas.jsf_primefaces_tutorials.service_layer.services.exceptions.RequestedResourceNotFoundException;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "dbStudentService")
@SessionScoped
@Getter
@Setter
public class DbStudentService extends AbstractService implements StudentService {

    @ManagedProperty(value = "#{studentDao}")
    private StudentDao studentDao;

    private TestDataProvider testDataProvider;

    @PostConstruct
    private void init() {
        testDataProvider = new TestDataProvider();
        initStudentsList(); // IllegalArgumentException, GeneralRollbackException
    }

    @Override
    public Student findStudentById(Long id) throws IllegalArgumentException, RequestedResourceNotFoundException {
        return studentDao.findById(id); // IllegalArgumentException, RequestedResourceNotFoundException
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public void saveStudent(Student student) throws IllegalArgumentException, GeneralRollbackException {

        Student studentToSave = Student.builder()
                .lastName(student.getLastName())
                .firstName(student.getFirstName())
                .dateOfBirth(student.getDateOfBirth())
                .absences(student.getAbsences())
                .departmentId(student.getDepartmentId())
                .status(student.getStatus())
                .build();
        studentDao.save(studentToSave); // IllegalArgumentException, GeneralRollbackException
    }

    @Override
    public void updateStudent(Student student, Long id) throws IllegalArgumentException, RequestedResourceNotFoundException, GeneralRollbackException {
        studentDao.update(student, id); // IllegalArgumentException, RequestedResourceNotFoundException, GeneralRollbackException
    }

    @Override
    public void deleteStudent(Long id) throws IllegalArgumentException, RequestedResourceNotFoundException, GeneralRollbackException {
        studentDao.deleteById(id); // IllegalArgumentException, RequestedResourceNotFoundException, GeneralRollbackException
    }

    private void initStudentsList() throws IllegalArgumentException, GeneralRollbackException {
        List<Student> students = testDataProvider.generateDBStudents();
        studentDao.saveAll(students); // IllegalArgumentException, GeneralRollbackException
    }
}
