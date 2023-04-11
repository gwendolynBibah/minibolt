package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.dto.RegisterRestaurantDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.subDto.RestaurantSubDto;
import com.gwen.minibolt.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<RestaurantSubDto> getRestaurants();

    Restaurant createRestaurant(RegisterRestaurantDto registerRestaurantDto);

    RestaurantDto updateRestaurant(String restaurantId, RegisterRestaurantDto restaurantDto);

    RestaurantDto getRestaurant(String id);

    void deleteRestaurant(String id);
}
