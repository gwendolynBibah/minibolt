package com.gwen.minibolt.dto;

import com.gwen.minibolt.dto.subDto.FoodSubDto;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.model.Restaurant;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Restaurant} entity
 */
public record RestaurantDto(String id, String location, double rating, String name, GENERAL_STATUS status, Boolean isActive, List<MenuDto> menus,
                            String ownerId,
                            String image,
                            String ownerName) implements Serializable {
    /**
     * A DTO for the {@link com.gwen.minibolt.model.Menu} entity
     */
    public record MenuDto(String id, String name, List<FoodSubDto> foods) implements Serializable {
    }
}