package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private LanguageEnum name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    private List<Word> words = new ArrayList<>();

    public Language(LanguageEnum name, String description) {
        this.name = name;
        this.description = description;
    }
}
