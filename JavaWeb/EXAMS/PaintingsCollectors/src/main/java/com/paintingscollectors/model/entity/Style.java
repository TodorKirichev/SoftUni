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
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private StyleName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "style", fetch = FetchType.EAGER)
    private Set<Painting> paintings;

    public Style() {
        this.paintings = new HashSet<>();
    }

    public Style(StyleName name, String description) {
        this.name = name;
        this.description = description;
    }
}
