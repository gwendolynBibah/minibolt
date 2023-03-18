package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.enums.OrderStatus;
import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.Order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link Order} entity
 */
public record OrderDto(Long id, OrderStatus status, Date timestamp, double totalPrice, List<FoodDto> food, Long userId,
                       String userName, Role userRole) implements Serializable {
}