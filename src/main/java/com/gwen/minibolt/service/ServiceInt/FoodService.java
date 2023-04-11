package com.gwen.minibolt.service.ServiceInt;


import com.gwen.minibolt.dto.CreateFoodDto;
import com.gwen.minibolt.dto.FoodDto;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface FoodService {
    List<FoodDto> getAllFood();

    FoodDto createFood(CreateFoodDto food);

    FoodDto getFood(@NotNull String id);

    void deleteFood(@NotNull String id);

    FoodDto updateFood(@NotNull String id, CreateFoodDto food);
}
