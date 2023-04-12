package com.gwen.minibolt.mappers.userimplmappers;

import com.gwen.minibolt.dtos.userImplDTOs.RestaurantListDto;
import com.gwen.minibolt.model.Restaurant;

public class restaurantListMapper {
    public RestaurantListDto restaurantListDto (Restaurant restaurant) {
       RestaurantListDto restaurantListDto = new RestaurantListDto();
       restaurantListDto.setName(restaurant.getRestaurantName());
       restaurantListDto.setLocation(restaurant.getLocation());
       restaurantListDto.setRating(restaurant.getRating());

       return  restaurantListDto;
    }
    public Restaurant toEntity (RestaurantListDto restaurantListDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantListDto.getName());
        restaurant.setLocation(restaurantListDto.getLocation());
        restaurant.setRating(restaurantListDto.getRating());

        return restaurant;
    }
}
