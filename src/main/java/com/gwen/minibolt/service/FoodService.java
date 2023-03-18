package com.gwen.minibolt.service;


import com.gwen.minibolt.Dtos.FoodDto;

import java.util.List;

public interface FoodService {
    List<FoodDto> getAllFood();
    FoodDto createFood(FoodDto food);
    FoodDto getFood(long id);
    void deleteFood(Long id);
}
