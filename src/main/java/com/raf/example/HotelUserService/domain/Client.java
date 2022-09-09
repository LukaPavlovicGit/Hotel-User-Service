package com.raf.example.HotelUserService.domain;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Client extends User{
    @NotBlank
    private String numOfPassport;
    private Integer numOfReservation;

    public Client(){
        this.numOfReservation = 0;
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
}
