package com.gwen.minibolt.mappers.userimplmappers;

import com.gwen.minibolt.dtos.userImplDTOs.RestaurantDTO;
import com.gwen.minibolt.model.Restaurant;

public class RestaurantMapper {
    public RestaurantDTO toRestaurantEntity(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setName(restaurant.getRestaurantName());
        restaurantDTO.setLocation(restaurant.getLocation());

        return restaurantDTO;
    }
    public Restaurant toRestaurantEntity (RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantDTO.getName());
        restaurant.setLocation(restaurant.getLocation());

        return restaurant;
    }
}
