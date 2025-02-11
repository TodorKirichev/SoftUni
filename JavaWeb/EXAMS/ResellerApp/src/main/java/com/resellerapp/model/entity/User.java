package com.resellerapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.EAGER)
    private List<Offer> offers;

    @OneToMany(mappedBy = "boughtBy", fetch = FetchType.EAGER)
    private List<Offer> boughtOffers;

    public User() {
        this.offers = new ArrayList<>();
        this.boughtOffers = new ArrayList<>();
    }
}
