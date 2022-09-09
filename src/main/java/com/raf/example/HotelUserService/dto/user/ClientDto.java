package com.raf.example.HotelUserService.dto.user;

import java.util.Date;


public class ClientDto {
    private String fistName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date birthdate;
    private Integer numOfPassport;
    private Integer numOfReservation;

    public ClientDto(){}

    public ClientDto(String fistName, String lastName, String email, String phoneNumber, Date birthdate, Integer numOfPassport, Integer numOfReservation) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.numOfPassport = numOfPassport;
        this.numOfReservation = numOfReservation;
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

    public Integer getNumOfPassport() {
        return numOfPassport;
    }

    public void setNumOfPassport(Integer numOfPassport) {
        this.numOfPassport = numOfPassport;
    }

    public Integer getNumOfReservation() {
        return numOfReservation;
    }

    public void setNumOfReservation(Integer numOfReservation) {
        this.numOfReservation = numOfReservation;
    }
}
