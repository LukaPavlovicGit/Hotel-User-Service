package com.raf.example.HotelUserService.domain;

import javax.persistence.*;


@Entity
@Table(indexes = {@Index(columnList = "name", unique = true)})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role(){}

    public Role(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
