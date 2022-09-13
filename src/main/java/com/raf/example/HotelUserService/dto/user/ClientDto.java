package com.raf.example.HotelUserService.dto.user;

import java.util.Date;


public class ClientDto extends UserDto {
    private String numOfPassport;
    private Integer numOfReservation;

    public ClientDto(){}


    public String getFistName() {
        return super.getFirstName();
    }

    public void setFistName(String fistName) {
        super.setFirstName(fistName);
    }

    public String getLastName() {
        return super.getLastName();
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public String getEmail() { return super.getEmail(); }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    public Date getBirthdate() {
        return super.getBirthdate();
    }

    public void setBirthdate(Date birthdate) { super.setBirthdate(birthdate); }

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
}
