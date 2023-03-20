package com.gwen.minibolt.repository;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.Dtos.RestaurantDto;
import com.gwen.minibolt.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {
    List<Menu> findAllByRestaurantId(Long restaurant_id);
}
