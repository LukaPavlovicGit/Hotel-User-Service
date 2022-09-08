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

public class ManagerCreateDto{
    @NotBlank
    private String username;

    @Length(min = 8, max = 20)
    private String password;

    @NotBlank
    private String fistName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private Date birthdate;

    @NotNull
    private Role role;

    @NotBlank
    private String hotelName;

    @NotBlank
    private Date hireDate;
}