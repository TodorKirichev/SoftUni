package com.likebookapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodName name;

    @Column
    private String description;

    @OneToMany(mappedBy = "mood", fetch = FetchType.EAGER)
    private Set<Post> posts;

    public Mood(MoodName name, String description) {
        this.name = name;
        this.description = description;
    }
}
