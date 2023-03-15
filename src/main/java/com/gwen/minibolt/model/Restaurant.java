package com.gwen.minibolt.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;
    private String location;
    private double rating;
    //private String themePicture;
   // private int userId;
    private String restaurantName;

    //foreign key ;
    @ManyToOne
    private User user;

    //image foreign key
    @OneToOne
    public Image image;
}
