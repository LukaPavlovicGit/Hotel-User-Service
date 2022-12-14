package com.raf.example.HotelUserService.domain;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
public class Manager extends User{

    @NotBlank
    private String hotelName;
    @NotBlank
    private Date hireDate;

    public Manager(){ }

    public Manager(String username, String password, String firstName, String lastName, String email, String phoneNumber, Date birthdate, Role role, Boolean activated, String hotelName, Date hireDate) {
        super(username, password, firstName, lastName, email, phoneNumber, birthdate, role, activated);
        this.hotelName = hotelName;
        this.hireDate = hireDate;
    }

    public Manager(String username, String firstName, String lastName, String email, String phoneNumber, Date birthdate, Role role, Boolean activated, String hotelName, Date hireDate) {
        super(username, firstName, lastName, email, phoneNumber, birthdate, role, activated);
        this.hotelName = hotelName;
        this.hireDate = hireDate;
    }

    public Manager(String hotelName, Date hireDate) {
        this.hotelName = hotelName;
        this.hireDate = hireDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
