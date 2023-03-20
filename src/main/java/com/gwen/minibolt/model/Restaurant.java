package com.gwen.minibolt.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

    //foreign key ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User owner;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private Set<OrderItem> orderItems;

    //image foreign key
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    public Image image;
}
