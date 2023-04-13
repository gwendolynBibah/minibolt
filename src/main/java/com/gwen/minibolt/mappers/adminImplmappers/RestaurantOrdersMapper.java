package com.gwen.minibolt.mappers.adminImplmappers;

import com.gwen.minibolt.dtos.adminImplDto.RestaurantOrdersDto;
import com.gwen.minibolt.model.Food;
import com.gwen.minibolt.model.OrderItem;
import com.gwen.minibolt.model.Restaurant;

public class RestaurantOrdersMapper {
    public RestaurantOrdersDto toDto (Food food, OrderItem orderItem, Restaurant restaurant) {
        RestaurantOrdersDto restaurantOrdersDto = new RestaurantOrdersDto();
        restaurantOrdersDto.setFoodName(food.getFoodName());
        restaurantOrdersDto.setFoodPrize(food.getFoodPrice());
        restaurantOrdersDto.setTimestamp(orderItem.getTimestamp());
        restaurantOrdersDto.setRestaurantName(restaurant.getRestaurantName());

        return restaurantOrdersDto;
    }
    public Food toFoodEntity (RestaurantOrdersDto restaurantOrdersDto) {
        Food food = new Food();
        food.setFoodName(restaurantOrdersDto.getFoodName());
        food.setFoodPrice(restaurantOrdersDto.getFoodPrize());

        return food;
    }
    public OrderItem toOrderItemEntity (RestaurantOrdersDto restaurantOrdersDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setTimestamp(restaurantOrdersDto.getTimestamp());

        return orderItem;
    }
    public Restaurant toRestaurantEntity (RestaurantOrdersDto restaurantOrdersDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantOrdersDto.getRestaurantName());

        return restaurant;
    }
}
