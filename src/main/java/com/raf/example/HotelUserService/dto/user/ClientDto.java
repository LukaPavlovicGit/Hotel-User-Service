package com.raf.example.HotelUserService.dto.user;

import java.sql.Date;


public class ClientDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date birthdate;
    private String numOfPassport;
    private Integer numOfReservation;

    public ClientDto(){}

    public ClientDto(String username, String firstName, String lastName, String email, String phoneNumber, Date birthdate, String numOfPassport, Integer numOfReservation) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.numOfPassport = numOfPassport;
        this.numOfReservation = numOfReservation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Integer getNumOfReservation() {
        return numOfReservation;
    }

    public void setNumOfReservation(Integer numOfReservation) {
        this.numOfReservation = numOfReservation;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthdate=" + birthdate +
                ", numOfPassport='" + numOfPassport + '\'' +
                ", numOfReservation=" + numOfReservation +
                '}';
    }
}
