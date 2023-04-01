package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAllByRestaurantId(Long restaurant_id);

    List<OrderItem> findAllByFoodId(Long food_id);

    List<OrderItem> findAllByFoodIdAndRestaurantId(Long food_id, Long restaurant_id);

}