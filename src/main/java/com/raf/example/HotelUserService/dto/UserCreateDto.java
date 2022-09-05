package com.raf.example.HotelUserService.dto;

import com.raf.example.HotelUserService.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class UserCreateDto {
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
}
