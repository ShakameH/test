package com.polytech.polywebproj.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Student")
    private Long id_Student;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "studentNumber")
    private Integer studentNumber;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "id_promIdentifier")
    private Prom prom;

    @OneToOne
    @JoinColumn(name = "id_Speciality")
    private Speciality speciality;

    @OneToOne
    @JoinColumn(name = "id_accountIdentifier")
    private Account account;



}
