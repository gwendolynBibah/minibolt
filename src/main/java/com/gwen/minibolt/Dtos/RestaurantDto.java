package com.gwen.minibolt.Dtos;

import com.gwen.minibolt.Dtos.subDto.FoodSubDto;
import com.gwen.minibolt.model.Restaurant;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Restaurant} entity
 */
public record RestaurantDto(Long id, String location, double rating, String name, List<MenuDto> menus, Long ownerId,
                            String ownerName) implements Serializable {
    /**
     * A DTO for the {@link com.gwen.minibolt.model.Menu} entity
     */
    public record MenuDto(Long id, String name, List<FoodSubDto> foods) implements Serializable {
    }
}