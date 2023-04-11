package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.Food;

import java.io.Serializable;

/**
 * A DTO for the {@link Food} entity
 */
public record FoodDto(String id, String name, double price, String description, String menuId, String menuName,
                      String restaurantId, String restaurantName) implements Serializable {
}