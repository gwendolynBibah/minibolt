package com.gwen.minibolt.mappers.restaurantimplmappers;

import com.gwen.minibolt.dtos.restaurantimplDto.CustomersAndTheirOrdersDto;
import com.gwen.minibolt.model.Food;
import com.gwen.minibolt.model.MiniboltUser;
import com.gwen.minibolt.model.OrderItem;
import com.gwen.minibolt.model.Restaurant;

public class CustomersAndTheirOrdersMappers {
    public CustomersAndTheirOrdersDto toDto (OrderItem orderItem, MiniboltUser user, Restaurant restaurant, Food food) {
        CustomersAndTheirOrdersDto customersAndTheirOrdersDto = new CustomersAndTheirOrdersDto();
        customersAndTheirOrdersDto.setCustomerName(user.getUserName());
        customersAndTheirOrdersDto.setRestaurantName(restaurant.getRestaurantName());
        customersAndTheirOrdersDto.setTimestamp(orderItem.getTimestamp());
        customersAndTheirOrdersDto.setFoodName(food.getFoodName());
        customersAndTheirOrdersDto.setFoodPrize(food.getFoodPrice());

        return customersAndTheirOrdersDto;
    }
    public MiniboltUser toUserEntity (CustomersAndTheirOrdersDto customersAndTheirOrdersDto) {
        MiniboltUser user = new MiniboltUser();
        user.setUserName(customersAndTheirOrdersDto.getCustomerName());
        return user;
    }
    public Restaurant toRestaurantEntity (CustomersAndTheirOrdersDto customersAndTheirOrdersDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(customersAndTheirOrdersDto.getRestaurantName());
        return restaurant;
    }
    public Food toFoodEntity (CustomersAndTheirOrdersDto customersAndTheirOrdersDto) {
        Food food = new Food();
        food.setFoodName(customersAndTheirOrdersDto.getFoodName());
        food.setFoodPrice(customersAndTheirOrdersDto.getFoodPrize());
        return food;
    }
    public OrderItem toOrderEntity (CustomersAndTheirOrdersDto customersAndTheirOrdersDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setTimestamp(customersAndTheirOrdersDto.getTimestamp());
        return orderItem;
    }
}
