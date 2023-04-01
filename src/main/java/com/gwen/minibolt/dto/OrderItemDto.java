package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.Order;
import com.gwen.minibolt.model.OrderItem;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link OrderItem} entity
 */
public record OrderItemDto(Long id, OrderDto order, FoodDto food, Date timeStamp) implements Serializable {
    /**
     * A DTO for the {@link Order} entity
     */
    public record OrderDto(UserDto user) implements Serializable {
    }
}