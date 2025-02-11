package com.resellerapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "OFFERS")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Condition condition;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    private User boughtBy;
}
