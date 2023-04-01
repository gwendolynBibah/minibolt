package com.gwen.minibolt.service.ServiceInt;


import com.gwen.minibolt.dto.CreateFoodDto;
import com.gwen.minibolt.dto.FoodDto;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface FoodService {
    List<FoodDto> getAllFood();

    FoodDto createFood(CreateFoodDto food);

    FoodDto getFood(@NotNull long id);

    void deleteFood(@NotNull Long id);

    FoodDto updateFood(@NotNull Long id, CreateFoodDto food);
}
