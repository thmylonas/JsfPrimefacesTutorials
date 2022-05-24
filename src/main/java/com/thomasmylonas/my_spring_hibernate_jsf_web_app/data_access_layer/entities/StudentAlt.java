package com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.enums.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "StudentAlt")
@Table(name = "student_alt", schema = "schooldb")
public class StudentAlt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name = "student_generator", sequenceName = "student_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "father_name", length = 20)
    private String fatherName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "absences")
    private Integer absences;

    @Column(name = "department_id", length = 10)
    private String departmentId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", length = 20)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAbsences() {
        return absences;
    }

    public void setAbsences(Integer absences) {
        this.absences = absences;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentAlt{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", absences=" + absences +
                ", departmentId='" + departmentId + '\'' +
                ", status=" + status +
                '}';
    }
}
