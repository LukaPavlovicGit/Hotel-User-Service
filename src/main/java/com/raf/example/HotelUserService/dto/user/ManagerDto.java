package com.raf.example.HotelUserService.dto.user;

import com.raf.example.HotelUserService.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
