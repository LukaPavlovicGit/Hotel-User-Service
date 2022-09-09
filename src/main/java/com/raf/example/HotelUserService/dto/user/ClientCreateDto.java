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


public class ClientCreateDto {
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

    public ClientCreateDto(){}
    public ClientCreateDto(String username, String password, String fistName, String lastName, String email, String phoneNumber, Date birthdate, Role role) {
        this.username = username;
        this.password = password;
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
