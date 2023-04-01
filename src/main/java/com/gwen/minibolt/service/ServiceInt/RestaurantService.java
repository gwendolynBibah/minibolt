package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.dto.RegisterRestaurantDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.subDto.RestaurantSubDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantSubDto> getRestaurants();

    RestaurantDto createRestaurant(RegisterRestaurantDto registerRestaurantDto);

    RestaurantDto updateRestaurant(Long restaurantId, RegisterRestaurantDto restaurantDto);

    RestaurantDto getRestaurant(Long id);

    void deleteRestaurant(Long id);
}
