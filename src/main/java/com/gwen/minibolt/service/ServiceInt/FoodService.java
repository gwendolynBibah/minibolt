package com.gwen.minibolt.service.ServiceInt;


import com.gwen.minibolt.Dtos.CreateFoodDto;
import com.gwen.minibolt.Dtos.FoodDto;

import java.util.List;

public interface FoodService {
    List<FoodDto> getAllFood();
    FoodDto createFood(CreateFoodDto food);
    FoodDto getFood(long id);
    void deleteFood(Long id);

    FoodDto updateFood(Long id, CreateFoodDto food);
}
