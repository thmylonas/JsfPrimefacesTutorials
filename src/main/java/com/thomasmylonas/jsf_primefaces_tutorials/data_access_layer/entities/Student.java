package com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities;

import com.thomasmylonas.jsf_primefaces_tutorials.data_access_layer.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "Student")
@Table(name = "Students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student {

    /**
     * Attention:
     * In this case, with the "AutoConfiguration" of H2, the
     * - @GeneratedValue(strategy = GenerationType.IDENTITY)
     * Fails to insert a row, with the error:
     * - ERROR SqlExceptionHelper - NULL not allowed for column "ID"; SQL statement: "..."
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Students_Sequence_Generator")
    @SequenceGenerator(name = "Students_Sequence_Generator", sequenceName = "Students_Sequence", allocationSize = 1)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Last_Name", length = 30)
    private String lastName;

    @Column(name = "First_Name", length = 20)
    private String firstName;

    @Column(name = "Date_Of_Birth")
    private LocalDate dateOfBirth;

    @Column(name = "Absences")
    private Integer absences;

    @Column(name = "Department_Id", length = 10)
    private String departmentId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "Status", length = 20)
    private Status status;
}
