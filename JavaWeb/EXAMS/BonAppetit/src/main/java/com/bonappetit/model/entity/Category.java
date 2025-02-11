package com.bonappetit.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryName name;

    @Column
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Recipe> recipes;

    public Category(CategoryName categoryName, String description) {
        this.name = categoryName;
        this.description = description;
    }
}
