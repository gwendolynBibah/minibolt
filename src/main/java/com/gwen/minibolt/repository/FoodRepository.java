package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
