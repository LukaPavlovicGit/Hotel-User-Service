package com.raf.example.HotelUserService.dto.user;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

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

    @NotBlank
    private String numOfPassport;

    public ClientCreateDto(){}

    public ClientCreateDto(String username, String password, String fistName, String lastName, String email, String phoneNumber, Date birthdate, String numOfPassport) {
        this.username = username;
        this.password = password;
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.numOfPassport = numOfPassport;
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

    public String getNumOfPassport() {
        return numOfPassport;
    }

    public void setNumOfPassport(String numOfPassport) {
        this.numOfPassport = numOfPassport;
    }

    @Override
    public String toString() {
        return "ClientCreateDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthdate=" + birthdate +
                ", numOfPassport='" + numOfPassport + '\'' +
                '}';
    }
}
