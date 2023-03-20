package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.Dtos.RegisterRestaurantDto;
import com.gwen.minibolt.Dtos.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getRestaurants();
    RestaurantDto createRestaurant(RegisterRestaurantDto registerRestaurantDto);

    RestaurantDto updateRestaurant(Long restaurantId, RegisterRestaurantDto restaurantDto);

    RestaurantDto getRestaurant(Long id);
    void deleteRestaurant(Long id);
}
