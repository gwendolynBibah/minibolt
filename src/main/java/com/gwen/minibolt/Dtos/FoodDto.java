package com.gwen.minibolt.Dtos;

import java.io.Serializable;

/**
 * A DTO for the {@link com.gwen.minibolt.model.Food} entity
 */
public record FoodDto(Long id, String name, double price, String description, Long menuId, String menuName,
                      Long menuRestaurantId, String menuRestaurantName) implements Serializable {
}