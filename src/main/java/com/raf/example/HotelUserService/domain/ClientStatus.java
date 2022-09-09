package com.raf.example.HotelUserService.domain;
import javax.persistence.*;

@Entity

public class ClientStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Boolean accessForbidden;
    private Integer discount;
    private String rank;

    public ClientStatus(){}

    public ClientStatus(Long id, Long userId, Boolean accessForbidden, Integer discount, String rank) {
        this.id = id;
        this.userId = userId;
        this.accessForbidden = accessForbidden;
        this.discount = discount;
        this.rank = rank;
    }

    public Long getId() {
        return id;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
