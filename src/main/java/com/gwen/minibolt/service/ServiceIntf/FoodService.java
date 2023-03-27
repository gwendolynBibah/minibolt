package com.gwen.minibolt.service.ServiceIntf;

import com.gwen.minibolt.model.Food;

import java.util.List;

public interface FoodService {

    List<Food> getAllFood();

    Food getFood(Long id);
    Food addFood(Food food);
}
