package com.paintingscollectors.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
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

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Painting> addedPaintings;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Painting> favouritePaintings;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Painting> ratedPaintings;

    public User() {
        this.addedPaintings = new HashSet<>();
        this.favouritePaintings = new HashSet<>();
        this.ratedPaintings = new HashSet<>();
    }
}
