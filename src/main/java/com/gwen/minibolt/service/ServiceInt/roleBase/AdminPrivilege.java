package com.gwen.minibolt.service.ServiceInt.roleBase;

import com.gwen.minibolt.dto.OrderItemDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.enums.ROLE;

import java.util.List;
import java.util.Map;

public interface AdminPrivilege {
    UserDto changeUserRole(Long userId, ROLE role);

    UserDto SuspendUser(Long userId);

    RestaurantDto suspendRestaurant(Long restaurantId);

    Map<UserDto, List<RestaurantDto>> getRestaurantsAndOwners();

    UserDto getRestaurantOwner(Long restaurant);

    List<RestaurantDto> getOwnerRestaurant(Long userId);

    List<OrderItemDto> getRestaurantOrders(Long restaurantId);

}
