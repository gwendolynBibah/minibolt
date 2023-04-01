package com.gwen.minibolt.model;

import com.gwen.minibolt.enums.ORDER_STATUS;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Data
@Entity
@Table(name = "orderItems")
@SQLDelete(sql = "UPDATE users SET deleted =true WHERE id=?")
//@Where(clause = "deleted=false")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date timeStamp;
    @Enumerated(value = EnumType.STRING)
    private ORDER_STATUS status;
    private boolean deleted = Boolean.FALSE;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
