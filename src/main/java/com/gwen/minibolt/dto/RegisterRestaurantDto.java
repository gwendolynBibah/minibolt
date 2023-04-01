package com.gwen.minibolt.dto;

import com.gwen.minibolt.model.Restaurant;

import java.io.Serializable;

/**
 * A DTO for the {@link Restaurant} entity
 */
public record RegisterRestaurantDto(String location, double rating, String name, Long ownerId) implements Serializable {
}