package com.gwen.minibolt.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private double rating;
    private String name;

    //foreign key ;
    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    //image foreign key
    @OneToOne(fetch = FetchType.LAZY)
    public Image image;
}
