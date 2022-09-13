package com.raf.example.HotelUserService.dto;

import javax.validation.constraints.NotBlank;

public class RankDto {
    @NotBlank
    private String name;
    @NotBlank
    private Integer reach;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReach() {
        return reach;
    }

    public void setReach(Integer reach) {
        this.reach = reach;
    }
}
