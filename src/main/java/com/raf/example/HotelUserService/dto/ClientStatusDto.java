package com.raf.example.HotelUserService.dto;

import com.raf.example.HotelUserService.domain.rank.RankEnum;

public class ClientStatusDto {

    private Long userId;
    private Boolean accessForbidden;
    private Integer discount;
    private RankEnum rankEnum;

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

    public RankEnum getRank() {
        return rankEnum;
    }

    public void setRank(RankEnum rankEnum) {
        this.rankEnum = rankEnum;
    }
}
