package com.gwen.minibolt.mappers.userimplmappers;

import com.gwen.minibolt.dtos.userImplDTOs.OrdersDto;
import com.gwen.minibolt.model.Food;
import com.gwen.minibolt.model.OrderItem;
import com.gwen.minibolt.model.Restaurant;

public class OrdersMappers {
    public OrdersDto toOrderDto(Food food, Restaurant restaurant, OrderItem orderItem) {
        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setFoodName(food.getFoodName());
        ordersDto.setFoodPrize(food.getFoodPrice());
        ordersDto.setTimestamp(orderItem.getTimestamp());
        ordersDto.setRestaurantName(restaurant.getRestaurantName());

        return ordersDto;
    }
    public Food toFoodEntity (OrdersDto ordersDto) {
        Food food = new Food();
        food.setFoodName(ordersDto.getFoodName());
        food.setFoodPrice(ordersDto.getFoodPrize());

        return food;
    }
    public OrderItem toOrderEntity(OrdersDto ordersDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setTimestamp(ordersDto.getTimestamp());

        return orderItem;
    }
    public Restaurant toRestaurantItem(OrdersDto ordersDto) {
        Restaurant restaurant =  new Restaurant();
        restaurant.setRestaurantName(ordersDto.getRestaurantName());

        return restaurant;
    }
}
