package com.gwen.minibolt.model;

import com.gwen.minibolt.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    private Date timestamp;

    //food foreign key
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Food> food;

    //user foreign key
    @ManyToOne
    private User user;

}
