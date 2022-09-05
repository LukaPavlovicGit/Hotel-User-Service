package com.raf.example.HotelUserService.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(indexes = {@Index(columnList = "username", unique = true), @Index(columnList = "email", unique = true)})
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String fistName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date birthdate;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
