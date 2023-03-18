package com.gwen.minibolt.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

}
