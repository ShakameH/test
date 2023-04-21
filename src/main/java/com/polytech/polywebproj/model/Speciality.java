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
@Table(name="tbl_Specialities")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_speciality", nullable = false)
    private Long id_Speciality;

    @Column(name = "nameSpeciality")
    private String nameSpeciality;
}
