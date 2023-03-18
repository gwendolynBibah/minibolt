package com.gwen.minibolt.model;


import com.gwen.minibolt.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;
    private Date timestamp;
    private double totalPrice;

    //food foreign key
    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> food;

    //user foreign key
    @ManyToOne  (cascade = CascadeType.ALL)
    private User user;

}
