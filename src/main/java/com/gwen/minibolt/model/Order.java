package com.gwen.minibolt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gwen.minibolt.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
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
    private Double totalPrice;

    //food foreign key
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    //user foreign key
    @ManyToOne
    @JoinColumn(name = "User_id", nullable = false)
    private MiniboltUser miniboltUser;

}
