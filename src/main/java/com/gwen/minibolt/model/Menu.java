package com.gwen.minibolt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    private String menuName;

    //food foreign key
    @JsonIgnore
    @OneToMany(mappedBy = "menu")
    private List<Food> food;

    //restaurant key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
