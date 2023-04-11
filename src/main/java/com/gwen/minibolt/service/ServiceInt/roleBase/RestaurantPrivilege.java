package com.gwen.minibolt.service.ServiceInt.roleBase;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.dto.FoodDto;
import com.gwen.minibolt.dto.OrderItemDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.dto.requests.MenuItemRequest;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.enums.ORDER_STATUS;

import java.util.List;
import java.util.Map;

public interface RestaurantPrivilege {
    List<FoodDto> displayAllFoodByRestaurant(String restaurantId);

    List<MenuDto> displayAllMenuByRestaurant(String restaurantId);

    //I want to alert the user/customer that a particular food is finished/out of stock
    MenuDto changeMenuStatus(String menuId, GENERAL_STATUS status);

    FoodDto changeFoodStatus(String foodId, GENERAL_STATUS status);

    RestaurantDto changeRestaurantStatus(String restaurantId, GENERAL_STATUS status);

    OrderItemDto confirmOrderItem(String orderItemId, ORDER_STATUS status);

    List<UserDto> getRestaurantCustomers(String restaurantId);

    List<UserDto> getRestaurantCustomersByMenu(String menuId);

    List<UserDto> getRestaurantCustomersByFood(String restaurantId, String foodId);

    Map<UserDto, List<OrderItemDto>> getCustomersAndTheirOrdersByRestaurant(String restaurantId);

    MenuDto removeMenuItem(String restaurantId, MenuItemRequest itemRequest);
}
