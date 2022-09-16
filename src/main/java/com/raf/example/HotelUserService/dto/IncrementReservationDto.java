package com.raf.example.HotelUserService.dto;

public class IncrementReservationDto {
    private Long userId;
    private boolean increment;

    public IncrementReservationDto(){}

    public IncrementReservationDto(Long userId, boolean increment) {
        this.userId = userId;
        this.increment = increment;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean getIncrement() {
        return increment;
    }

    public void setIncrement(boolean increment) {
        this.increment = increment;
    }
}
