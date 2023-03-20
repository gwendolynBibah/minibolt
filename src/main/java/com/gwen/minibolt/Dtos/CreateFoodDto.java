package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.model.Food;

import java.io.Serializable;

/**
 * A DTO for the {@link Food} entity
 */
public record CreateFoodDto(String name, double price, String description, Long menuId) implements Serializable {
}