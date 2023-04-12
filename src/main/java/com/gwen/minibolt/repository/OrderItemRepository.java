package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
List<OrderItem> findAllByRestaurant_RestaurantId(long restaurantId);
}
