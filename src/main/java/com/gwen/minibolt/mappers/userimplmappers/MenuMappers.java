package com.gwen.minibolt.mappers.userimplmappers;

import com.gwen.minibolt.dtos.userImplDTOs.MenuDTO;
import com.gwen.minibolt.model.Food;

public class MenuMappers {
    public MenuDTO toMenuDto(Food food) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setFoodName(food.getFoodName());
        menuDTO.setFoodPrize(food.getFoodPrice());
        menuDTO.setFoodDescription(food.getFoodDescription());

        return menuDTO;
    }
    public Food toFoodEntity(MenuDTO menuDTO) {
        Food food = new Food();
        food.setFoodName(menuDTO.getFoodName());
        food.setFoodPrice(menuDTO.getFoodPrize());
        food.setFoodDescription(menuDTO.getFoodDescription());

        return food;
    }
}
