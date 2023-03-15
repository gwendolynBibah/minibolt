package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
