package com.gwen.minibolt.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gwen.minibolt.enums.ORDER_STATUS;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    @Enumerated(value = EnumType.STRING)
    private ORDER_STATUS status;
    private Date timestamp;
    private double totalPrice;

    //food foreign key
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    //user foreign key
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
