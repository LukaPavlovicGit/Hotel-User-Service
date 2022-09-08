package com.raf.example.HotelUserService.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Manager extends User{

    @NotBlank
    private String hotelName;
    @NotBlank
    private Date hireDate;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
