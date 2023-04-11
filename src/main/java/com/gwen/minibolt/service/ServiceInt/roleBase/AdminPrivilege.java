package com.gwen.minibolt.service.ServiceInt.roleBase;

import com.gwen.minibolt.dto.OrderItemDto;
import com.gwen.minibolt.dto.RestaurantDto;
import com.gwen.minibolt.dto.UserDto;
import com.gwen.minibolt.enums.ROLE;

import java.util.List;
import java.util.Map;

public interface AdminPrivilege {
    UserDto changeUserRole(String userId, ROLE role);

    UserDto SuspendUser(String userId);

    RestaurantDto suspendRestaurant(String restaurantId);

    Map<UserDto, List<RestaurantDto>> getRestaurantsAndOwners();

    UserDto getRestaurantOwner(String restaurant);

    List<RestaurantDto> getOwnerRestaurant(String userId);

    List<OrderItemDto> getRestaurantOrders(String restaurantId);

}
