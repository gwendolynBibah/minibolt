package com.gwen.minibolt.service.ServiceInt.roleBase;

import com.gwen.minibolt.Dtos.MenuDto;
import com.gwen.minibolt.dto.OrderDto;
import com.gwen.minibolt.dto.OrderItemDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.enums.ORDER_STATUS;

import java.util.List;
import java.util.Map;

public interface UserPrivilege {
    RestaurantDto rateRestaurant(Long restaurant, Double rating);

    OrderItemDto placeOrderItem(OrderItemDto orderItemDto);

    OrderDto placeOrder(List<OrderItemDto> oderItems);

    Map<String, List<RestaurantDto>> getRestaurantGroupedByLocation();

    List<RestaurantDto> getRestaurantsByLocation(String location);

    Object ownARestaurant(Object ownershipDetails);

    ORDER_STATUS getOrderStatus(Long orderId);

    List<MenuDto> getRestaurantMenuAndFoodPrices(Long restaurantId);

    List<RestaurantDto> getRestaurantsByStatusAndLocation(GENERAL_STATUS status, String location);

    List<MenuDto> getRestaurantMenuByStatus(Long restaurantId, GENERAL_STATUS status);

    List<RestaurantDto> getRestaurantsByStatus(GENERAL_STATUS status);
}
