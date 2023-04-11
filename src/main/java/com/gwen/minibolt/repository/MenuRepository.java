package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {
    List<Menu> findAllByRestaurantId(String restaurant_id);

    Optional<Menu> findByRestaurantIdAndId(String restaurant_id, String menuId);
}
