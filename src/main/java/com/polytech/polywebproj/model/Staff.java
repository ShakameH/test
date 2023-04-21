package com.polytech.polywebproj.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_StaffMember")
    private Long id_StaffMember;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="signupDate")
    private Date signupDate;

    @Column(name="function")
    private Integer function;

    @Column(name="staffNumber")
    private String staffNumber;

    @OneToOne
    @JoinColumn(name = "id_accountIdentifier")
    private Account account;

}
