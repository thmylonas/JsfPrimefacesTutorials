package com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.models.spring_framework_models;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.enums.Status;

import java.util.Date;

public class StudentAltModel {

    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    private Integer absences;
    private String departmentId;
    private Status status;

    public StudentAltModel() {
    }

    private StudentAltModel(Builder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.dateOfBirth = builder.dateOfBirth;
        this.absences = builder.absences;
        this.departmentId = builder.departmentId;
        this.status = builder.status;
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
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", absences=" + absences +
                ", departmentId='" + departmentId + '\'' +
                ", status=" + status +
                '}';
    }

    public static class Builder {

        private String lastName;
        private String firstName;
        private Date dateOfBirth;
        private Integer absences;
        private String departmentId;
        private Status status;

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder absences(Integer absences) {
            this.absences = absences;
            return this;
        }

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public StudentAltModel build() {
            return new StudentAltModel(this);
        }
    }
}
