package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Menu;
import com.gwen.minibolt.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    List<Menu> findAllByRestaurant_RestaurantId(Long restaurant_restaurantId);
    //List<Menu> findAllByRestaurantId(Long restaurant_id);
}
