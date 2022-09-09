package com.raf.example.HotelUserService.domain;
import javax.persistence.*;

@Entity
public class Client extends User{

    private Integer numOfPassport = 0;
    private Integer numOfReservation = 0;

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
