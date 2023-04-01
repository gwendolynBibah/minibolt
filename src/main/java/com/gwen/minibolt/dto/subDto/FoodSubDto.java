package com.gwen.minibolt.dto.subDto;

import com.gwen.minibolt.model.Food;

import java.io.Serializable;

/**
 * A DTO for the {@link Food} entity
 */
public record FoodSubDto(Long id, String name, double price, String description) implements Serializable {
}