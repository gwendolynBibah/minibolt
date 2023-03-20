package com.gwen.minibolt.Dtos.subDto;

import com.gwen.minibolt.Dtos.RRTownDto;
import com.gwen.minibolt.model.Restaurant;

import java.io.Serializable;

/**
 * A DTO for the {@link Restaurant} entity
 */
public record RestaurantSubDto(Long id, String location, String name) implements Serializable {
}