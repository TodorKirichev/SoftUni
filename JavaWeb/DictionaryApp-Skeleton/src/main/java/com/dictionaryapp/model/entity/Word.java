package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private String translation;

    @Column
    private String example;

    @Column(nullable = false)
    private LocalDate inputDate;

    @ManyToOne(optional = false)
    private Language language;

    @ManyToOne(optional = false)
    private User addedBy;
}
