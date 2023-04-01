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
    List<FoodDto> displayAllFoodByRestaurant(Long restaurantId);

    List<MenuDto> displayAllMenuByRestaurant(Long restaurantId);

    //I want to alert the user/customer that a particular food is finished/out of stock
    MenuDto changeMenuStatus(Long menuId, GENERAL_STATUS status);

    FoodDto changeFoodStatus(Long foodId, GENERAL_STATUS status);

    RestaurantDto changeRestaurantStatus(Long restaurantId, GENERAL_STATUS status);

    OrderItemDto confirmOrderItem(Long orderItemId, ORDER_STATUS status);

    List<UserDto> getRestaurantCustomers(Long restaurantId);

    List<UserDto> getRestaurantCustomersByMenu(Long menuId);

    List<UserDto> getRestaurantCustomersByFood(Long restaurantId, Long foodId);

    Map<UserDto, List<OrderItemDto>> getCustomersAndTheirOrdersByRestaurant(Long restaurantId);

    MenuDto removeMenuItem(Long restaurantId, MenuItemRequest itemRequest);
}
