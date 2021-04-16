package com.dev.iccaka.questionmark.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "website")
    private String website;

    @Column(name = "university")
    private String university;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "dateOfRegistration")
    private LocalDateTime dateOfRegistration;

    @Column(name = "dateOfLastLogin")
    private LocalDateTime dateOfLastLogin;

    @OneToOne
    @JoinColumn(name = "roleid")
    private Role roleid;

    @OneToOne
    @JoinColumn(name = "countryid")
    private Country countryid;
}
