package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.Food;

import java.io.Serializable;

/**
 * A DTO for the {@link Food} entity
 */
public record FoodDto(Long id, String name, double price, String description, Long menuId, String menuName,
                      Long restaurantId, String restaurantName) implements Serializable {
}