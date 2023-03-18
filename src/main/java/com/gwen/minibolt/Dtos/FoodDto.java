package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.model.Food;

import java.io.Serializable;

/**
 * A DTO for the {@link Food} entity
 */
public record FoodDto(Long id, String name, double price, String description, String menuName) implements Serializable {
}