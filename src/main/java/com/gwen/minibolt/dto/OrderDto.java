package com.gwen.minibolt.dto;

import com.gwen.minibolt.enums.ORDER_STATUS;
import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.model.Order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * A DTO for the {@link Order} entity
 */
public record OrderDto(Long id, ORDER_STATUS status, Date timestamp, double totalPrice, List<FoodDto> food, Long userId,
                       String userName, ROLE userRole) implements Serializable {
}