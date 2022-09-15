package com.raf.example.HotelUserService.domain;

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
    @OneToOne
    private Rank rank;

    public ClientStatus(){ }

    public ClientStatus(Long userId, Rank rank) {
        this.userId = userId;
        this.rank = rank;
        this.accessForbidden = false;
        this.discount = 0;
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