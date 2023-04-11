package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, String> {
    List<OrderItem> findAllByRestaurantId(String restaurant_id);

    List<OrderItem> findAllByFoodId(String food_id);

    List<OrderItem> findAllByFoodIdAndRestaurantId(String food_id, String restaurant_id);

}