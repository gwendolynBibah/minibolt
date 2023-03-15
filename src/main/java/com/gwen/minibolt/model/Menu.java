package com.gwen.minibolt.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;

@Data
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    private String menuName;

    //food foreign key
    @OneToOne(cascade = CascadeType.ALL)
    private Food food;

    //restaurant key
    @ManyToOne
    private Restaurant restaurant;
}
