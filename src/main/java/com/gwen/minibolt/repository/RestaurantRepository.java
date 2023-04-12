package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.Restaurant;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}