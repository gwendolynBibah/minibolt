package com.gwen.minibolt.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    private String location;
    private double rating;
    private String restaurantName;

    //user foreign key ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private MiniboltUser owner;

    //image foreign key
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    public Image image;

    //restauraunt foreign key
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List <Menu> menus;

    //orderitem foreign key
   @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private Set<OrderItem> orderItems;
}
