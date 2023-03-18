package com.gwen.minibolt.service;

import com.gwen.minibolt.Dtos.OrderDto;
import com.gwen.minibolt.Dtos.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getAllRestaurant();
    RestaurantDto createRestaurant(RestaurantDto order);
    RestaurantDto getRestaurant(long id);
    void deleteRestaurant(Long id);
}
