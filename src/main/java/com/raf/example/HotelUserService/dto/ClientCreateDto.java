package com.raf.example.HotelUserService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ClientCreateDto {
    private String username;
    private String password;
    private String fistName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date birthdate;
}