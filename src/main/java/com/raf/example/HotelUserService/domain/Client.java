package com.raf.example.HotelUserService.domain;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
public class Client extends User{
    @NotBlank
    private String numOfPassport;
    private Integer numOfReservation;

    public Client(){
        this.numOfReservation = 0;
    }

    public Client(String username, String password, String firstName, String lastName, String email, String phoneNumber, Date birthdate, Role role, Boolean activated, String numOfPassport, Integer numOfReservation) {
        super(username, password, firstName, lastName, email, phoneNumber, birthdate, role, activated);
        this.numOfPassport = numOfPassport;
        this.numOfReservation = numOfReservation;
    }

    public Client(String username, String firstName, String lastName, String email, String phoneNumber, Date birthdate, Role role, Boolean activated, String numOfPassport, Integer numOfReservation) {
        super(username, firstName, lastName, email, phoneNumber, birthdate, role, activated);
        this.numOfPassport = numOfPassport;
        this.numOfReservation = numOfReservation;
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
