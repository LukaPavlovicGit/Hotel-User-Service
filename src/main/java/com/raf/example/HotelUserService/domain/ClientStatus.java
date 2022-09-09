package com.raf.example.HotelUserService.domain;
import com.raf.example.HotelUserService.rank.Rank;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(indexes = {@Index(columnList = "userId", unique = true)})
public class ClientStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private Long userId;
    private Boolean accessForbidden;
    private Integer discount;
    private Rank rank;

    public ClientStatus(){
        this.accessForbidden = false;
        this.discount = 0;
        this.rank = Rank.BRONZE;
    }

    public ClientStatus(Long userId) {
        this.userId = userId;
        this.accessForbidden = false;
        this.discount = 0;
        this.rank = Rank.BRONZE;
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

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}