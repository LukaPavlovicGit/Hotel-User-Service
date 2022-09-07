package com.raf.example.HotelUserService.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ManagerDto {
    private String fistName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date birthdate;
    private String hotelName;
    private Date hireDate;
}
