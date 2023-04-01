package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findAllByRestaurantId(Long restaurant_id);

    Optional<Menu> findByRestaurantIdAndId(Long restaurant_id, Long menuId);
}
