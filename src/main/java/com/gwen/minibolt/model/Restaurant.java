package com.gwen.minibolt.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "restaurants")
@SQLDelete(sql = "UPDATE users SET deleted =true WHERE id=?")
//@Where(clause = "deleted=false")
public class Restaurant {
    //image foreign key
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    public Image image;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private double rating;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private GENERAL_STATUS status = GENERAL_STATUS.UNAVAILABLE;
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;
    //foreign key ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;
    private Boolean isActive = Boolean.FALSE;
    private boolean deleted = Boolean.FALSE;
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private Set<OrderItem> orderItems;
}
