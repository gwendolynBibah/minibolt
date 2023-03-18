package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.enums.Role;
import com.gwen.minibolt.model.Restaurant;

import java.io.Serializable;

/**
 * A DTO for the {@link Restaurant} entity
 */
public record RestaurantDto(Long id, String location, double rating, String name, String ownerName, Role ownerRole,
                            Byte[] imageContent) implements Serializable {
}