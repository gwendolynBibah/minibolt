package com.gwen.minibolt.dto.subDto;

import com.gwen.minibolt.model.Restaurant;

import java.io.Serializable;

/**
 * A DTO for the {@link Restaurant} entity
 */
public record RestaurantSubDto(String id, String location, String name, String image) implements Serializable {
}