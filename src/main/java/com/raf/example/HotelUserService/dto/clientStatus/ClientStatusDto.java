package com.raf.example.HotelUserService.dto.clientStatus;

import com.raf.example.HotelUserService.rank.Rank;

public class ClientStatusDto {

    private Long userId;
    private Boolean accessForbidden;
    private Integer discount;
    private Rank rank;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getAccessForbidden() {
        return accessForbidden;
    }

    public void setAccessForbidden(Boolean accessForbidden) {
        this.accessForbidden = accessForbidden;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
