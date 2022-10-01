package com.raf.example.HotelUserService.dto;

import com.raf.example.HotelUserService.domain.Rank;
import com.raf.example.HotelUserService.domain.rank.RankEnum;

public class ClientStatusDto {

    private Long userId;
    private Boolean accessForbidden;
    private Integer discount;
    private Rank rank;


    public ClientStatusDto(Long userId, Boolean accessForbidden, Integer discount, Rank rank) {
        this.userId = userId;
        this.accessForbidden = accessForbidden;
        this.discount = discount;
        this.rank = rank;
    }

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

    public void setRank(Rank rankEnum) {
        this.rank = rankEnum;
    }
}
