package com.gwen.minibolt.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy="order")
    private List<OrderItem> orderItems;

    //user foreign key
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}
