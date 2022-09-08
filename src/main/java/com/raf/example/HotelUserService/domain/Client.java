package com.raf.example.HotelUserService.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor

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
